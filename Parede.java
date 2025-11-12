import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Parede extends Actor {
    private int dano = 1; // Dano que a parede causa ao jogador
    private int cooldownDano = 0; // Para evitar dano contínuo
    
    public Parede() {
        // Usa a imagem original da parede
        setImage("obstaculos/parede.png.jpg");
        // Redimensiona a imagem para um tamanho adequado
        GreenfootImage img = getImage();
        img.scale(50, 40);
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
        // Verifica se o jogador está tocando na parede
        Jogador jogador = (Jogador) getOneIntersectingObject(Jogador.class);
        if (jogador != null && cooldownDano == 0) {
            // A parede causa dano ao jogador quando ele encosta nela
            jogador.sofrerDano(dano);
            
            // Define cooldown para evitar dano contínuo (1 segundo)
            cooldownDano = 60;
            
            // Empurra o jogador para longe da parede
            empurrarJogador(jogador);
        }
    }
    
    private void empurrarJogador(Jogador jogador) {
        // Calcula a direção para empurrar o jogador para longe da parede
        int dx = jogador.getX() - getX();
        int dy = jogador.getY() - getY();
        
        // Força do empurrão
        int empurraoForça = 25;
        
        // Empurra na direção que for maior (horizontal ou vertical)
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
