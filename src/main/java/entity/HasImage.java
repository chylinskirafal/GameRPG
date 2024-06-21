package entity;

import java.awt.image.BufferedImage;

public interface HasImage extends HasPosition {
    public BufferedImage getImage(int animationIndex);
}
