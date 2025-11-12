import greenfoot.*;

public class Pedra extends Actor {
    private int dano = 1; // Mesmo dano que a parede
    private int cooldownDano = 0;
    
    public Pedra() {
        // Usa a imagem da parede mas com cor cinza
        setImage("obstaculos/parede.png.jpg");
        GreenfootImage img = getImage();
        
        // Torna a pedra cinza
        img.setColor(Color.GRAY);
        img.fill();
        img.scale(45, 45);
        setImage(img);
    }
    
    public void act() {
        verificarColisaoJogador();
        
        // Reduz o cooldown do dano
        if (cooldownDano > 0) {
            cooldownDano--;
        }
    }
    
    private void verificarColisaoJogador() {
        Jogador jogador = (Jogador) getOneIntersectingObject(Jogador.class);
        if (jogador != null && cooldownDano == 0) {
            // Causa dano ao jogador
            jogador.sofrerDano(dano);
            
            // Define cooldown
            cooldownDano = 45; // Cooldown médio
            
            // Empurra o jogador levemente
            empurrarJogador(jogador);
        }
    }
    
    private void empurrarJogador(Jogador jogador) {
        // Calcula a direção para empurrar o jogador
        int dx = jogador.getX() - getX();
        int dy = jogador.getY() - getY();
        
        // Empurrão menor que a parede
        int empurraoForça = 20;
        
        if (Math.abs(dx) > Math.abs(dy)) {
            // Empurra horizontalmente
            if (dx > 0) {
                jogador.setLocation(jogador.getX() + empurraoForça, jogador.getY());
            } else {
                jogador.setLocation(jogador.getX() - empurraoForça, jogador.getY());
            }
        } else {
            // Empurra verticalmente
            if (dy > 0) {
                jogador.setLocation(jogador.getX(), jogador.getY() + empurraoForça);
            } else {
                jogador.setLocation(jogador.getX(), jogador.getY() - empurraoForça);
            }
        }
    }
}
