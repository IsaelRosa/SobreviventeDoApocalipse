import greenfoot.*;

public class Projetil extends Actor {
    private int velocidade = 8;
    private int dano = 2;
    private int alcanceMaximo = 300;
    private int distanciaPercorrida = 0;
    
    public Projetil(int direcao) {
        // Cria uma imagem pequena e amarela para o projétil
        GreenfootImage img = new GreenfootImage(6, 6);
        img.setColor(Color.YELLOW);
        img.fillOval(0, 0, 6, 6);
        setImage(img);
        
        // Define a direção do projétil
        setRotation(direcao);
    }
    
    public void act() {
        // Verifica se ainda está no mundo antes de fazer qualquer coisa
        if (getWorld() == null) return;
        
        // Move o projétil para frente
        move(velocidade);
        distanciaPercorrida += velocidade;
        
        // Verifica se ainda está no mundo após o movimento
        if (getWorld() == null) return;
        
        // Verifica colisão com inimigos (pode remover o projétil)
        verificarColisaoInimigo();
        
        // Verifica se o projétil ainda está no mundo antes de continuar
        if (getWorld() != null) {
            // Remove o projétil se saiu da tela ou atingiu alcance máximo
            if (isAtEdge() || distanciaPercorrida >= alcanceMaximo) {
                getWorld().removeObject(this);
            }
        }
    }
    
    private void verificarColisaoInimigo() {
        Inimigo inimigo = (Inimigo) getOneIntersectingObject(Inimigo.class);
        if (inimigo != null && getWorld() != null) {
            // Armazena as coordenadas antes de qualquer remoção
            int x = getX();
            int y = getY();
            World mundo = getWorld();
            
            // Causa dano ao inimigo
            inimigo.sofrerDano(dano);
            
            // Adiciona efeito visual
            mundo.addObject(new EfeitoAtaque(), x, y);
            
            // Dá pontos ao jogador
            java.util.List<Jogador> jogadores = mundo.getObjects(Jogador.class);
            if (!jogadores.isEmpty()) {
                jogadores.get(0).adicionarPontos(10);
            }
            
            // Remove o projétil após o impacto
            mundo.removeObject(this);
        }
    }
}
