package entity.systems;

import entity.inferface.HasCollision;

public abstract class Collides {

    int worldPosTop, worldPosRight, worldPosBottom, worldPosLeft;
    int worldPosCenterX, worldPosCenterY;

    public Collides() {
//        worldPosTop = entity.getY() + entity.getSolidArea().y;
//        worldPosRight = entity.getX() + entity.getSolidArea().x + entity.getSolidArea().width;
//        worldPosBottom = entity.getY() + entity.getSolidArea().y+ entity.getSolidArea().height;
//        worldPosLeft = entity.getX() + + entity.getSolidArea().x;
//
//        worldPosCenterX = entity.getX() + entity.getSolidArea().x + entity.getSolidArea().width / 2;
//        worldPosCenterY = entity.getY() + entity.getSolidArea().y + entity.getSolidArea().height / 2;
    }

    public static enum CollisionType {
        Top, Left, Bottom, Right;
    }
}


/*

X,Y []

Enemy
//Player
Tiles
Obcjety

=> listy

player.colizje(lista)

foreach -> enum //

 */