package entity;

import pl.chylu.GamePanel;
import pl.chylu.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PlayerCopy extends Entity implements HasPosition, HasDirection, HasSpeed, HasImage  {
    GamePanel gp;
    KeyHandler keyHandler;

    public int worldX, worldY;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public Direction direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public boolean collisionOn = false;

    public PlayerCopy(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyHandler = keyH;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    //Podstawowe współrzędne gdzie bohater ma się pojawić na mapie i z którym zaczytanym assetem
    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = Direction.Down;
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

    @Override()
    public void update(GamePanel gp) {
        KeyHandler keyH = gp.keyH;
        //Wychwytywanie co wcisnął użytkownik
        if (keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true) {
            if (keyHandler.upPressed == true) {
                direction = Direction.Up;
            } else if (keyHandler.downPressed == true) {
                direction = Direction.Down;
            } else if (keyHandler.leftPressed == true) {
                direction = Direction.Left;
            } else if (keyHandler.rightPressed == true) {
                direction = Direction.Right;
            }
        }

        //Sprawdzanie kolizji z podłożem
        collisionOn = true;
        //gp.collisionChecker.checkTile(this);

        //Kolizja fałszywa (false), bohater może się ruszać
        if(collisionOn == false) {
            switch (direction) {
                case Up:
                    worldY -= speed;
                    break;
                case Down:
                    worldY += speed;
                    break;
                case Left:
                    worldX -= speed;
                    break;
                case Right:
                    worldX += speed;
                    break;
            }

        }

        if(keyH.upPressed == true) {
            worldY -= speed;
        } else if(keyH.downPressed == true) {
            worldY += speed;
        } else if(keyH.leftPressed == true) {
            worldX -= speed;
        } else if(keyH.rightPressed == true) {
            worldX += speed;
        }

        gp.cameraPosition = new Point(worldX, worldY);

        //Sprawdzanie który z dwóch assetów donego kierunku bohatera ma być pokazany
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

    @Override
    public void draw(Graphics2D g, GamePanel gp) {

    }

    @Override
    public BufferedImage getImage(int animationIndex) {
        switch(direction) {
            case Up:
                if (spriteNum == 1) {
                    return up1;
                } else if (spriteNum == 2) {
                    return up2;
                }
                break;
            case Down:
                if (spriteNum == 1) {
                    return down1;
                } else if (spriteNum == 2) {
                    return down2;
                }
                break;
            case Left:
                if (spriteNum == 1) {
                    return left1;
                } else if (spriteNum == 2) {
                    return left2;
                }
                break;
            case Right:
                if (spriteNum == 1) {
                    return right1;
                } else if (spriteNum == 2) {
                    return right2;
                }
                break;
        }
        return null;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public int getX() {
        return worldX;
    }

    @Override
    public int getY() {
        return worldY;
    }

}
