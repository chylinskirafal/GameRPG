package entity.inferface;

import entity.systems.Entity;
import pl.chylu.coregame.GamePanel;

import java.awt.*;
import java.util.List;

public interface SystemInterface {
    public void setup(GamePanel gp);
    public void update(GamePanel gp);
    public void draw(List<Entity> entities, Graphics2D g2, GamePanel gp);
}
