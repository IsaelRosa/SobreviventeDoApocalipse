import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TelaInicial extends World {
    public TelaInicial() {
        super(800, 600, 1);
        
        setBackground("faseRuasCidade.jpg");
        // Se não tiver imagem, use fundo colorido:
        getBackground().setColor(Color.DARK_GRAY);
        getBackground().fill();
        
        prepararTela();
    }
    private void prepararTela() {
        showText("SOBREVIVENTE DO APOCALIPSE", 400, 200);
        showText("Pressione ESPAÇO para iniciar", 400, 300);
        showText("Pressione I para instruções", 400, 350);
    }
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            // somMenu.stop();
            Greenfoot.setWorld(new FaseRuasCidade());
        }
        if (Greenfoot.isKeyDown("i")) {
            // somMenu.stop();
            Greenfoot.setWorld(new TelaInstrucoes());
        }
    }
}