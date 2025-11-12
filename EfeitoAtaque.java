import greenfoot.*;

public class EfeitoAtaque extends Actor {
    private int duracaoVida = 10;
    
    public EfeitoAtaque() {
        // Cria um pequeno círculo vermelho para representar o ataque
        GreenfootImage img = new GreenfootImage(15, 15);
        img.setColor(Color.RED);
        img.fillOval(0, 0, 15, 15);
        setImage(img);
    }
    
    public void act() {
        duracaoVida--;
        if (duracaoVida <= 0 && getWorld() != null) {
            getWorld().removeObject(this);
        }
    }
}
