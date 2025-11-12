import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class IndicadorMira extends Actor {
    private Jogador jogador;
    
    public IndicadorMira(Jogador jogador) {
        this.jogador = jogador;
        // Cria uma pequena linha vermelha para indicar direção
        GreenfootImage img = new GreenfootImage(20, 2);
        img.setColor(Color.RED);
        img.fillRect(0, 0, 20, 2);
        setImage(img);
    }
    
    public void act() {
        if (jogador != null && jogador.getWorld() != null && jogador.getTemArma()) {
            // Posiciona o indicador próximo ao jogador
            setLocation(jogador.getX() + 25, jogador.getY());
            
            // Alinha com a direção da mira do jogador
            if (Greenfoot.isKeyDown("up")) {
                setRotation(270);
                setLocation(jogador.getX(), jogador.getY() - 25);
            }
            else if (Greenfoot.isKeyDown("down")) {
                setRotation(90);
                setLocation(jogador.getX(), jogador.getY() + 25);
            }
            else if (Greenfoot.isKeyDown("left")) {
                setRotation(180);
                setLocation(jogador.getX() - 25, jogador.getY());
            }
            else if (Greenfoot.isKeyDown("right")) {
                setRotation(0);
                setLocation(jogador.getX() + 25, jogador.getY());
            }
        } else {
            // Remove o indicador se não há jogador ou arma
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }
}
