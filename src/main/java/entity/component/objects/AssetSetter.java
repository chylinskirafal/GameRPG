package entity.component.objects;

import pl.chylu.coregame.GamePanel;
import tiles.Tile;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;

public class AssetSetter {

    GamePanel gp;
    public static SuperObject assetsList[] = new SuperObject[21];
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject () {
        gp.objects.add(new OBJ_Key());
        gp.objects.get(0).worldX = 23 * gp.tileSize;
        gp.objects.get(0).worldY = 7 * gp.tileSize;

        gp.objects.add(new OBJ_Key());
        gp.objects.get(1).worldX = 23 * gp.tileSize;
        gp.objects.get(1).worldY = 40 * gp.tileSize;
    }

    public void createAssets () {
        try {
            assetsList[0] = new OBJ_Key(ImageIO.read(getClass().getResourceAsStream("/objects/key.png")));
            assetsList[1] = new OBJ_Door(ImageIO.read(getClass().getResourceAsStream("/objects/door.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
