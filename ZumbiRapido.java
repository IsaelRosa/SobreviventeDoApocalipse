import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ZumbiRapido extends Inimigo {
    public ZumbiRapido() {
        super(2, 3, 1); // vida, velocidade, dano
        setImage("personagens/zumbi_rapido.png.png");
        // Redimensiona a imagem para um tamanho adequado
        GreenfootImage img = getImage();
        img.scale(90, 90);
        setImage(img);
    }
    
    public void act() {
        procurarJogador();
        mover();
        verificarColisaoJogador();
    }
    
    public void mover() {
        if (alvo != null && alvo.getWorld() != null) {
            turnTowards(alvo.getX(), alvo.getY());
        }
        move(velocidade);
    }
    
    public void atacar() {
        // Implementação do ataque
    }
    
    private void verificarColisaoJogador() {
        Jogador jogador = (Jogador) getOneIntersectingObject(Jogador.class);
        if (jogador != null) {
            jogador.sofrerDano(dano);
        }
    }
}