package entity.component.objects;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OBJ_Door extends SuperObject{

    public OBJ_Door() {
        name = "Door";
    }

    public OBJ_Door(BufferedImage image) {
        name = "Door";
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