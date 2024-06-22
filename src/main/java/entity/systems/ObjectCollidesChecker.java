package entity.systems;

import entity.component.objects.SuperObject;
import entity.inferface.HasCollision;

import java.util.HashSet;

public class ObjectCollidesChecker extends Collides {

    private final SuperObject superObjectList;

    public ObjectCollidesChecker(SuperObject superObjectList) {
        this.superObjectList = superObjectList;
    }
    public HashSet<ObjectCollidesChecker.CollisionType> hasCollides(HasCollision entity) {


        var collisions = new HashSet<ObjectCollidesChecker.CollisionType>();

        return collisions;
    }


}
