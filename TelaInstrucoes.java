import greenfoot.*;

public class TelaInstrucoes extends World {
    public TelaInstrucoes() {
        super(1000, 700, 1);
        prepararTela();
    }
    
    private void prepararTela() {
        showText("INSTRUÇÕES", 500, 100);
        showText("WASD - Movimentar", 500, 180);
        showText("Setas direcionais - Mirar", 500, 210);
        showText("ESPAÇO - Atirar (quando tiver arma)", 500, 240);
        showText("Colete kits de cura, armas e chaves", 500, 280);
        showText("Evite os zumbis!", 500, 320);
        showText("Pressione ESPAÇO para voltar", 500, 500);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new TelaInicial());
        }
    }
}
