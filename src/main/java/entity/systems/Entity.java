package entity.systems;

import pl.chylu.coregame.GamePanel;

import java.awt.*;


public abstract class Entity {
    public abstract void update(GamePanel gp);
    public abstract void draw(Graphics2D g, GamePanel gp);
}


