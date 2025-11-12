import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Jogador extends Actor {
    private int vida = 10;
    private int velocidade = 4;
    private int pontuacao = 0;
    private int chavesColetadas = 0;
    private boolean temArma = false;
    private int danoArma = 2;
    private int cooldownAtaque = 0;
    private int direcaoMira = 0; 

    public Jogador() {
        setImage("personagens/jogador.png.png");
        // Redimensiona a imagem para um tamanho adequado
        GreenfootImage img = getImage();
        img.scale(100, 100);
        setImage(img);
    }

    public void act() {
        // Verifica se o jogador ainda está vivo
        if (vida <= 0) {
            gameOver();
            return; // Para a execução se o jogo terminou
        }
        
        mover();
        coletarItens();
        controlarMira();
        atirar();

        // Reduz o cooldown de ataque
        if (cooldownAtaque > 0) {
            cooldownAtaque--;
        }
    }

    private void mover() {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - velocidade);
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + velocidade);
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - velocidade, getY());
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + velocidade, getY());
        }
    }

    private void coletarItens() {
        // Verifica colisão com itens
        Item item = (Item) getOneIntersectingObject(Item.class);
        if (item != null) {
            item.coletar(this);
        }
    }

    public void sofrerDano(int quantidade) {
        vida -= quantidade;
        
        // Reproduz o som dos zombies quando o jogador sofre dano
        Greenfoot.playSound("Zombies.wav");
        
        // Verifica se morreu após sofrer dano
        if (vida <= 0) {
            vida = 0;
            gameOver();
        }
    }

    public void curar(int quantidade) {
        vida += quantidade;
        if (vida > 10) vida = 10;
    }

    public void adicionarPontos(int pontos) {
        pontuacao += pontos;
    }

    public void adicionarChave() {
        chavesColetadas++;
    }

    public void equiparArma() {
        temArma = true;
    }

    private void controlarMira() {
        // Usa as setas direcionais para controlar a mira
        if (Greenfoot.isKeyDown("up")) {
            direcaoMira = 270; // Para cima
        }
        else if (Greenfoot.isKeyDown("down")) {
            direcaoMira = 90; // Para baixo
        }
        else if (Greenfoot.isKeyDown("left")) {
            direcaoMira = 180; // Para esquerda
        }
        else if (Greenfoot.isKeyDown("right")) {
            direcaoMira = 0; // Para direita
        }
    }

    public void atirar() {
        if (Greenfoot.isKeyDown("space") && temArma && cooldownAtaque == 0) {
            // Criar projétil
            Projetil projetil = new Projetil(direcaoMira);
            getWorld().addObject(projetil, getX(), getY());

            // Som de tiro
            Greenfoot.playSound("tiro.wav");

            // Define cooldown para evitar disparo muito rápido
            cooldownAtaque = 15;
        }
    }

    private void gameOver() {
        
        getWorld().showText("GAME OVER", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        getWorld().showText("Pontuação: " + pontuacao, getWorld().getWidth() / 2, getWorld().getHeight() / 2 + 40);
        Greenfoot.stop();
                
    }

    public int getChavesColetadas() {
        return chavesColetadas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getVida() {
        return vida;
    }

    public boolean getTemArma() {
        return temArma;
    }
}