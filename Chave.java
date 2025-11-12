// Chave.java
import greenfoot.*;

public class Chave extends Item {
    public Chave() {
        setImage("itens/chave.png.png");
        nome = "Chave";
        // Redimensiona a imagem para um tamanho adequado
        GreenfootImage img = getImage();
        img.scale(25, 25);
        setImage(img);
    }
    
    public void coletar(Jogador jogador) {
        jogador.adicionarChave();
        jogador.adicionarPontos(200);
        
        // Verifica se todos os inimigos foram mortos antes de tocar som de vitória
        verificarVitoria();
        
        getWorld().removeObject(this);
    }
    
    private void verificarVitoria() {
        // Conta quantos inimigos ainda restam no mundo
        java.util.List<Inimigo> inimigos = getWorld().getObjects(Inimigo.class);
        
        if (inimigos.isEmpty()) {
            // Todos os inimigos foram mortos, toca som de vitória
            Greenfoot.playSound("vitoria.wav");
            
            // Mostra mensagem de vitória
            getWorld().showText("VITÓRIA!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            getWorld().showText("Todos os zumbis foram eliminados!", getWorld().getWidth() / 2, getWorld().getHeight() / 2 + 40);
        }
    }
}
