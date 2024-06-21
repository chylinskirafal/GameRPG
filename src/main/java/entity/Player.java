package entity;

import pl.chylu.GamePanel;
import pl.chylu.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyHandler;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyHandler = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 350;
        y = 250;
        speed = 4;
        direction = "down";
    }

    //pobieranie assetów grafik
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/WalkingSprites/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/WalkingSprites/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/WalkingSprites/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/WalkingSprites/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/WalkingSprites/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/WalkingSprites/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/WalkingSprites/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/WalkingSprites/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Assets player not loaded");
        }
    }

    public void update() {
        if (keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true) {
            if (keyHandler.upPressed == true) {
                direction = "up";
                y -= speed;
            } else if (keyHandler.downPressed == true) {
                direction = "down";
                y += speed;
            } else if (keyHandler.leftPressed == true) {
                direction = "left";
                x -= speed;
            } else if (keyHandler.rightPressed == true) {
                direction = "right";
                x += speed;
            }
        }
        spriteCounter++;
        if (spriteCounter >= 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics g2) {
        BufferedImage image = null;
        switch(direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                } else if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                } else if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                } else if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}