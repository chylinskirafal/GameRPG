package pl.chylu;

import entity.Entity;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    //sprawdzania powierzchni kolizji
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArena.x;
        int entityRightWorldX = entity.worldX + entity.solidArena.x + entity.solidArena.width;
        int entityTopWorldY = entity.worldY + entity.solidArena.y;
        int entityBottomWorldY = entity.worldY + entity.solidArena.y + entity.solidArena.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                break;
            case "left":
                break;
            case "right":
                break;
        }
    }
}
