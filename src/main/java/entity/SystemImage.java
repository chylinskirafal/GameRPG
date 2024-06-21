package entity;

import pl.chylu.GamePanel;

import java.awt.*;
import java.util.List;

public class SystemImage implements SystemInterface {
    @Override
    public void setup(GamePanel gp) {

    }

    @Override
    public void update(GamePanel gp) {

    }

    public void draw(List<Entity> entities, Graphics2D g2, GamePanel gp) {
        var cameraPos = gp.cameraPosition;
        var screenWidth = gp.screenWidth;
        var screenHeight = gp.screenHeight;

        var offsetX = (int)(screenWidth / 2 - cameraPos.getX());
        var offsetY = (int)(screenHeight / 2 - cameraPos.getY());

        for (Entity entity : entities) {
            if(entity instanceof HasImage casted) {
                var image = casted.getImage(0);
                var x = casted.getX();
                var y = casted.getY();

                var screenX = x + offsetX;
                var screenY = y + offsetY;

                var halfTile = gp.tileSize / 2;

                g2.drawImage(image, screenX - halfTile, screenY - halfTile, gp.tileSize, gp.tileSize, null);
            }
        }
    }
}
