package tiles;

import pl.chylu.GamePanel;

import java.awt.image.BufferedImage;

public class Tile {
    private final BufferedImage image;
    private final boolean collision;


    public Tile(BufferedImage image, boolean collision) {
        this.image = image;
        this.collision = collision;
    }

    public BufferedImage getImage(int animationIndex) {
        return image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isCollision() {
        return collision;
    }
}
