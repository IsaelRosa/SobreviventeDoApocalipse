import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class KitCura extends Item {
    public KitCura() {
        setImage("itens/kit_cura.png.png");
        nome = "Kit de Cura";
        // Redimensiona a imagem para um tamanho adequado
        GreenfootImage img = getImage();
        img.scale(25, 25);
        setImage(img);
    }
    
    public void coletar(Jogador jogador) {
        jogador.curar(3);
        jogador.adicionarPontos(50);
        getWorld().removeObject(this);
    }
}
