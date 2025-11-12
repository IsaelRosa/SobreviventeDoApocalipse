import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Arma extends Item {
    public Arma() {
        setImage("itens/arma.png.png");
        nome = "Arma";
        // Redimensiona a imagem para um tamanho adequado
        GreenfootImage img = getImage();
        img.scale(60, 60);
        setImage(img);
    }
    
    public void coletar(Jogador jogador) {
        jogador.equiparArma();
        jogador.adicionarPontos(100);
        
        // Adiciona indicador de mira
        getWorld().addObject(new IndicadorMira(jogador), jogador.getX(), jogador.getY());
        
        getWorld().removeObject(this);
    }
}