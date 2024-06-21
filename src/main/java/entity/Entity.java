package entity;

import pl.chylu.GamePanel;
import pl.chylu.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    public abstract void update(GamePanel gp);
    public abstract void draw(Graphics2D g, GamePanel gp);
    // public int worldX, worldY;
    // public int speed;

    // public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    // public String direction;

    // public int spriteCounter = 0;
    // public int spriteNum = 1;

    // public Rectangle solidArea;
    // public boolean collisionOn = false;
}


