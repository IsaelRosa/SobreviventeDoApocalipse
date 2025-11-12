import greenfoot.*;

public abstract class Inimigo extends Actor {
    protected int vida;
    protected int velocidade;
    protected int dano;
    protected Jogador alvo;
    
    public Inimigo(int vida, int velocidade, int dano) {
        this.vida = vida;
        this.velocidade = velocidade;
        this.dano = dano;
    }
    
    public abstract void mover();
    public abstract void atacar();
    
    public void sofrerDano(int quantidade) {
        vida -= quantidade;
        if (vida <= 0) {
            morrer();
        }
    }
    
    protected void morrer() {
        // Dá pontos ao jogador quando o inimigo morre
        java.util.List<Jogador> jogadores = getWorld().getObjects(Jogador.class);
        if (!jogadores.isEmpty()) {
            jogadores.get(0).adicionarPontos(50);
        }
        getWorld().removeObject(this);
    }
    
    protected void procurarJogador() {
        // Reset alvo se ele foi removido do mundo
        if (alvo != null && alvo.getWorld() == null) {
            alvo = null;
        }
        
        if (alvo == null) {
            java.util.List<Jogador> jogadores = getWorld().getObjects(Jogador.class);
            if (!jogadores.isEmpty()) {
                alvo = jogadores.get(0);
            }
        }
    }
}