import greenfoot.*;

public class Mutante extends Inimigo {
    public Mutante() {
        super(5, 2, 2); // vida, velocidade, dano
        setImage("personagens/mutante.png.png");
        // Redimensiona a imagem para um tamanho adequado
        GreenfootImage img = getImage();
        img.scale(120, 120);
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
