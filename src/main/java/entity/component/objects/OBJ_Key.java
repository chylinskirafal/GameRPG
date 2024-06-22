package entity.component.objects;

import entity.inferface.HasCollision;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OBJ_Key extends SuperObject{

    public OBJ_Key() {
        name = "Key";
    }

    public OBJ_Key(BufferedImage image) {
        name = "Key";
        this.image = image;
    }

    @Override
    public Rectangle getSolidArea() {
        return null;
    }

    @Override
    public BufferedImage getImage(int animationIndex) {
        return null;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }
}
