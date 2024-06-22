package entity.component.objects;

import entity.inferface.HasCollision;
import entity.inferface.HasImage;
import entity.inferface.HasPosition;
import entity.systems.Direction;
import entity.systems.Entity;
import pl.chylu.coregame.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class SuperObject extends Entity implements HasPosition, HasImage, HasCollision {
    public int worldX, worldY;
    public BufferedImage image;
    public Direction direction;
    public String name;

    @Override
    public void update(GamePanel gp) {

    }

    @Override
    public void draw(Graphics2D g, GamePanel gp) {

    }
}
