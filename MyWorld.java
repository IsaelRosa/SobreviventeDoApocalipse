import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World {
    public MyWorld() {
        super(800, 600, 1);
        // Inicia diretamente na tela inicial
        Greenfoot.setWorld(new TelaInicial());
    }
}