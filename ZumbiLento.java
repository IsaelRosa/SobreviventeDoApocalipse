import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ZumbiLento extends Inimigo {
    private int contadorMovimento = 0;
    
    public ZumbiLento() {
        super(3, 1, 1); // vida, velocidade, dano
        setImage("personagens/zumbi_lento.png.png");
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
        contadorMovimento++;
        if (contadorMovimento >= 30) { // Move a cada 30 acts
            if (alvo != null && alvo.getWorld() != null) {
                turnTowards(alvo.getX(), alvo.getY());
            }
            move(velocidade);
            contadorMovimento = 0;
        }
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