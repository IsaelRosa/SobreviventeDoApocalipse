import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Armadilha extends Actor {
    private int dano = 2; // Dano maior que a parede
    private boolean ativa = true;
    private int cooldownDano = 0;
    
    public Armadilha() {
        // Usa a imagem da parede por enquanto, mas com cor diferente
        setImage("obstaculos/parede.png.jpg");
        GreenfootImage img = getImage();
        
        // Torna a armadilha vermelha para diferenciá-la
        img.setColor(Color.RED);
        img.fill();
        img.scale(40, 40);
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
        if (jogador != null && ativa && cooldownDano == 0) {
            // Causa dano ao jogador
            jogador.sofrerDano(dano);
            
            // Define cooldown para evitar dano contínuo
            cooldownDano = 30; // Menor cooldown que a parede (mais perigoso)
            
            piscarArmadilha();
            
            Greenfoot.playSound("Zombies.wav");
        }
    }
    
    private void piscarArmadilha() {
        // Muda temporariamente a cor para indicar que foi ativada
        GreenfootImage img = getImage();
        img.setColor(Color.YELLOW);
        img.fill();
        
        // Programa para voltar à cor original
        Greenfoot.getRandomNumber(1); // Pequeno delay
        
        img.setColor(Color.RED);
        img.fill();
    }
}
