package entity.inferface;

import java.awt.image.BufferedImage;

public interface HasImage extends HasPosition {
    public BufferedImage getImage(int animationIndex);
}
