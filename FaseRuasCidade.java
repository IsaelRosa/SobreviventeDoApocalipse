import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FaseRuasCidade extends World {
    private Jogador jogador;
    private int mamutesMortos = 0;
    private int zumbisMortos = 0;
    private boolean chaveColetada = false;
    private int totalMamutes = 3;  // Total de mamutes na fase
    private int totalZumbis = 5;   // Total de zumbis na fase
    private boolean faseCompleta = false;
    
    
    public FaseRuasCidade() {
        // Cria um novo mundo com 1000x700 células,
        // com células de tamanho 1x1 pixels.    
        super(1000, 700, 1);
        setBackground("faseRuasCidade.jpg");
        
        // Adiciona o jogador
        addObject(new Jogador(), 100, 350);
        
        // Adiciona inimigos
        addObject(new ZumbiLento(), 800, 350);
        addObject(new ZumbiRapido(), 900, 200);
        addObject(new Mutante(), 750, 500);
        
        // Adiciona itens
        addObject(new KitCura(), 500, 200);
        addObject(new Arma(), 300, 400);
        addObject(new Chave(), 700, 100);
        addObject(new KitCura(), 400, 600);
        
        // Adiciona paredes como obstáculos que causam dano ao jogador
        addObject(new Parede(), 500, 350);
        addObject(new Parede(), 550, 350);
        addObject(new Parede(), 600, 350);
        addObject(new Parede(), 250, 500);
        addObject(new Parede(), 800, 150);
        addObject(new Parede(), 200, 200);
        addObject(new Parede(), 850, 450);
    }
    
    public void act() {
        mostrarInformacoes();
    }
    
    private void mostrarInformacoes() {
        // Busca o jogador (otimizado)
        java.util.List<Jogador> jogadores = getObjects(Jogador.class);
        if (!jogadores.isEmpty()) {
            Jogador jogador = jogadores.get(0);
            
            // Mostra informações do jogador
            showText("Vida: " + jogador.getVida(), 900, 30);
            showText("Pontos: " + jogador.getPontuacao(), 900, 50);
            showText("Chaves: " + jogador.getChavesColetadas(), 900, 70);
            showText("Arma: " + (jogador.getTemArma() ? "SIM" : "NÃO"), 900, 90);
            
            // Instruções de combate
            if (jogador.getTemArma()) {
                showText("Use SETAS para mirar e ESPAÇO para atirar", 200, 30);
            } else {
                showText("Encontre uma arma para se defender!", 200, 30);
            }
        }
    }
}