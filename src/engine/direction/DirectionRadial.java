package engine.direction;

import static engine.direction.Direction.pi;
import game.entities.AbstractEntity;

public class DirectionRadial {
    
    private float angle;
    private static final float degree = 2*pi / 360;
    
    public DirectionRadial() {
        angle = 999;
    }
    
    public float getAngle() {
        if (angle == 999) {
            throw new IllegalArgumentException();   //Used as a flag to activate "null" direction
        }
        
        angle = simplify(angle);
        return angle;
    }
    
    /**
     * Places angle a in correct threshold [0, 2*pi) 
     */
    public static float simplify(float a) {
        if (a < 0) {
            a += 2 * pi;
        } else if (a >= 2 * pi) {
            a -= 2 * pi;
        }
        return a;
    }
    
    public void reset() {
        angle = 999;                                //Unique angle to flag a "null" direction
    }
    
    public void add(float n) {
        angle += n * degree;
        if (angle > 2*pi) {
            angle -= 2*pi;
        }
    }
    
    public void set(float n) {
        if (n < 0) {
            throw new IllegalArgumentException("Passed in radian is negative");
        } else if (n >= 2 * pi) {
            throw new IllegalArgumentException("Passed in degree is greater than or equal to 2*pi");
        }
        angle = n;
    }
    
    public void setInDegrees(float n) {
        if (n < 0) {
            throw new IllegalArgumentException("Passed in degree is negative");
        } else if (n >= 360) {
            throw new IllegalArgumentException("Passed in degree is greater than or equal to 360");
        }
        angle = n * degree;
    }
    
    /**
     * Directs this GameObject toward another GameObject go
     */
    public float directToward(AbstractEntity parent, AbstractEntity e) {
//        float atanYX = (float) Math.atan((double) (e.getY() - parent.getY()) / (e.getX() - parent.getX()));   //Keeping this unused variable for later use.
        float atanXY = (float) Math.atan((double) (e.getX() - parent.getX()) / (e.getY() - parent.getY()));
        
        //There are probably more efficient or intuitive ways to find the angle between 
        //the two GameObjects, but this is the most work-efficient way I could think of
        if (parent.getY() <= e.getY()) {
            angle = (float) pi / 2;
        } else {
            angle = -(float) pi / 2;
        }
        angle -= atanXY;
        
        return angle;
    }
    
    public static float getDirectionToward(AbstractEntity parent, AbstractEntity e) {
//        float atanYX = (float) Math.atan((double) (e.getY() - parent.getY()) / (e.getX() - parent.getX()));   //Keeping this unused variable for later use.
        float atanXY = (float) Math.atan((double) (e.getX() - parent.getX()) / (e.getY() - parent.getY()));
        
        float a;
        //There are probably more efficient or intuitive ways to find the angle between 
        //the two GameObjects, but this is the most work-efficient way I could think of
        if (parent.getY() <= e.getY()) {
            a = (float) pi / 2;
        } else {
            a = -(float) pi / 2;
        }
        a -= atanXY;
        
        a = simplify(a);
        
        return a;
    }
}
