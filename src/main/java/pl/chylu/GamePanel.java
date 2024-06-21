package pl.chylu;

import entity.Player;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16; // Modele będą mieć 16x16
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48x48 tile

    //Ustawienia świata gry
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = maxWorldCol * tileSize;
    public final int worldHeight = maxWorldRow * tileSize;

    //FPS
    final int FPS = 60;

    //rozmiar ilości "pikseli"
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixel
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixel

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionChecker collisionChecker = new CollisionChecker(this);

    TileManager tileManager = new TileManager(this);
    public Player player = new Player(this, keyH);


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        //Liczenie czasu odświeżania - docelowo 0.016(6) sec / 1/60 sekundy odświeżania
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;


        while (gameThread != null) {
            // 1. Opóźnienie czasu pomiędzy odświeżaniem
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;


            if (delta >= 1) {
                // 2. Update: aktualizowanie pozycji bohatera
                update();

                // 3. Rysowanie: rysowanie na nowo zmian na ekranie gry
                repaint();
                delta--;
                drawCount++;
            }

            //TODO przekształcić licznik FPS konsoli do rogu aplikacji
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }

    //zmiana współrzędnych bohatera użytkownika
    public void update() {
        if(keyH.upPressed == true) {
            player.worldY -= player.speed;
        } else if(keyH.downPressed == true) {
            player.worldY += player.speed;
        } else if(keyH.leftPressed == true) {
            player.worldX -= player.speed;
        } else if(keyH.rightPressed == true) {
            player.worldX += player.speed;
        }
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        tileManager.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
