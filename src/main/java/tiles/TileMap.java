package tiles;

import entity.systems.Entity;
import entity.systems.TileCollidesChecker;
import pl.chylu.coregame.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TileMap extends Entity {
    public Tile[] tile;
    public ArrayList<ArrayList<Integer>> map;

    public final TileCollidesChecker collisionChecker;

    public TileMap(int tileSize) {
        tile = new Tile[10];
        createTiles();
        loadMap("/map/world01.txt");
        //System.out.println(this.toString());
        this.collisionChecker = new TileCollidesChecker(tileSize, this);
    }

    // Ładowanie grafik tła
    public void createTiles() {
        try {
            tile[0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png")), false);
            tile[1] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png")), true);
            tile[2] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/water.png")), true);
            tile[3] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png")), false);
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

            String line;
            map = new ArrayList<ArrayList<Integer>>();
            while((line = br.readLine()) != null) {
                var split = line.split(" ");
                var thisLine = new ArrayList<Integer>();
                map.add(thisLine);
                for (String s : split) {
                    thisLine.add(Integer.parseInt(s));
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
        int y = 0;
        int x = 0;

        while (y < map.size() && x < map.get(0).size()) {
            int tileNum = map.get(y).get(x);

            int worldX = x * gp.tileSize;
            int worldY = y * gp.tileSize;
            int screenX = worldX - (int)gp.cameraPosition.getX() + (gp.screenWidth/2);
            int screenY = worldY - (int)gp.cameraPosition.getY() + (gp.screenHeight/2);


            g2.drawImage(tile[tileNum].getImage(), screenX, screenY, gp.tileSize, gp.tileSize, null);

            y++;

            if (y == map.size()) {
                y = 0;
                x++;
            }
        }
    }

    public Tile getTile(int x, int y) {
        if(y < 0 || y >= map.size() || x < 0 || x >= map.get(0).size()) {
            return tile[0];
        }
        return this.tile[map.get(y).get(x)];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(var row: map) {
            for(var tile: row) {
                sb.append(tile);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
