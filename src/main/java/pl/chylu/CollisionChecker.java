package pl.chylu;

import entity.inferface.HasCollision;
import tiles.TileMap;

import java.util.ArrayList;
import java.util.HashSet;

public class CollisionChecker {
    private final int tileSize;
    private final TileMap tileMap;

    public CollisionChecker(int tileSize, TileMap tileMap) {
        this.tileSize = tileSize;
        this.tileMap = tileMap;
    }

    //sprawdzania powierzchni kolizji
    public HashSet<CollisionType> checkIfCollides(HasCollision entity) {
        int worldPosTop = entity.getY() + entity.getSolidArea().y;
        int worldPosRight = entity.getX() + entity.getSolidArea().x + entity.getSolidArea().width;
        int worldPosBottom = entity.getY() + entity.getSolidArea().y+ entity.getSolidArea().height;
        int worldPosLeft = entity.getX() + + entity.getSolidArea().x;

        int worldPosCenterX = entity.getX() + entity.getSolidArea().x + entity.getSolidArea().width / 2;
        int worldPosCenterY = entity.getY() + entity.getSolidArea().y + entity.getSolidArea().height / 2;

        int tilePosTop = worldPosTop / tileSize;
        int tilePosRight = worldPosRight / tileSize;
        int tilePosBottom = worldPosBottom / tileSize;
        int tilePosLeft = worldPosLeft / tileSize;

        int tilePosCenterX = worldPosCenterX / tileSize;
        int tilePosCenterY = worldPosCenterY / tileSize;

        var tileTop = tileMap.getTile(tilePosCenterX, tilePosTop).isCollision();
        var tileRight = tileMap.getTile(tilePosRight, tilePosCenterY).isCollision();
        var tileBottom = tileMap.getTile(tilePosCenterX, tilePosBottom).isCollision();
        var tileLeft = tileMap.getTile(tilePosLeft, tilePosCenterY).isCollision();


        var collisions = new HashSet<CollisionType>();

        if(tileTop) {
            collisions.add(CollisionType.Top);
        }
        if(tileRight) {
            collisions.add(CollisionType.Right);
        }
        if(tileBottom) {
            collisions.add(CollisionType.Bottom);
        }
        if(tileLeft) {
            collisions.add(CollisionType.Left);
        }
        return collisions;
    }

    public static enum CollisionType {
        Top, Left, Bottom, Right;
    }
}
