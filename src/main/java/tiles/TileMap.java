package tiles;

import entity.Entity;
import pl.chylu.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileMap extends Entity {
    public Tile[] tile;
    public int mapTileNum[][];
    private final int sizeX;

    public int getSizeY() {
        return sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    private final int sizeY;

    public TileMap(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        tile = new Tile[10];
        createTiles();
        mapTileNum = new int[sizeX][sizeY];
        loadMap("/map/world01.txt");
    }

    // Ładowanie grafik tła
    public void createTiles() {
        try {
            tile[0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png")), false);
            tile[1] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png")), true);
            tile[2] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/water.png")), true);
            tile[3] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png")), true);
            tile[4] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png")), true);
            tile[5] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png")), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Ładowanie siatki mapy
    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < sizeY && row < sizeX) {
                String line = br.readLine();
                while (col < sizeY) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == sizeY) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(GamePanel gp) {
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < sizeY && worldRow < sizeX) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - (int)gp.cameraPosition.getX() + (gp.screenHeight/2) + (int)(gp.tileSize*1.5);
            int screenY = worldY - (int)gp.cameraPosition.getY() + (gp.screenWidth/2) - (int)(gp.tileSize*2.5);


            g2.drawImage(tile[tileNum].getImage(), screenX, screenY, gp.tileSize, gp.tileSize, null);

            worldCol++;

            if (worldCol == sizeY) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
