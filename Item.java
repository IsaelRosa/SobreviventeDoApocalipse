import greenfoot.*;

public abstract class Item extends Actor {
    protected String nome;
    
    public abstract void coletar(Jogador jogador);
}
