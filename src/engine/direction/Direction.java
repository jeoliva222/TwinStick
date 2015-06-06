package engine.direction;

import game.entities.AbstractEntity;

public class Direction {
    
    protected boolean isCardinal;
    
    protected boolean isNull;
    
    protected DirectionRadial radial;
    protected DirectionCardinal cardinal;
    
    protected float xMag;           //Magnitude of x movement
    protected float yMag;           //Magnitude of y movement
    
    protected AbstractEntity parent;    //The GameObject that contains this instance of a Direction
    protected float xPos;           //x position of parent
    protected float yPos;           //y position of parent
    
    protected static final float pi = (float) Math.PI;
    
    public Direction(AbstractEntity go) {
        isCardinal = false;
        
        isNull = false;
        
        radial = new DirectionRadial();
        cardinal = new DirectionCardinal();
        
        xMag = 0;
        yMag = 0;
        
        parent = go;
        xPos = parent.getX();
        yPos = parent.getY();
    }
    
    public Direction() {
        isCardinal = false;
        
        isNull = false;
        
        radial = new DirectionRadial();
        cardinal = new DirectionCardinal();
        
        xMag = 0;
        yMag = 0;
    }
    
    
    
    
    
    public float getX() {
        return xMag;
    }
    
    public float getY() {
        return yMag;
    }
    
    public boolean isNull() {
        return isNull;
    }
    
    public float getAngle() {
        if (isCardinal) {
            return cardinal.getAngle();
        }
        
        return radial.getAngle();
    }
    
    public void resetXY() {
        isNull = true;
        cardinal.reset();
        radial.reset();
//        xMag = 0;
//        yMag = 0;
    }
    
    public void resetX() {
        xMag = 0;
    }
    
    public void resetY() {
        yMag = 0;
    }
    
    public void refreshXY() {
        xPos = parent.getX();
        yPos = parent.getY();
        
        isNull = false;
        try {
            if (isCardinal) {
                xMag = (float) Math.cos(cardinal.getAngle());
                yMag = (float) Math.sin(cardinal.getAngle());
            } else {
                xMag = (float) Math.cos(radial.getAngle());
                yMag = (float) Math.sin(radial.getAngle());
            }
        } catch (IllegalArgumentException emptyString_OR_resetAngle) {        //Set's "null" direction if empty String or reset angle
            resetXY();
        }
    }
    
    
    
    
    
    public void setToRadial() {
        isCardinal = false;
    }
    
    public float add(float n) {
        radial.add(n);
        
        return radial.getAngle();
    }
    
    public float set(float n) {
        radial.set(n);
        
        return radial.getAngle();
    }
    
    public float setInDegrees(float n) {
        radial.setInDegrees(n);
        
        return radial.getAngle();
    }
    
    public float toward(AbstractEntity go) {
        if (isCardinal) {
            throw new IllegalStateException(parent.toString() + "'s Direction is in cardinal mode");
        }
        radial.directToward(parent, go);
        
        return radial.getAngle();
    }
    
    public void toward(AbstractEntity forceParent, AbstractEntity go) {
        if (isCardinal) {
            throw new IllegalStateException(parent.toString() + "'s Direction is in cardinal mode");
        }
        radial.directToward(forceParent, go);
    }
    
    
    
    
    
    public void setToCardinal() {
        isCardinal = true;
    }
    
    public void addUpCardinal() {
        if (!isCardinal) {
            throw new IllegalStateException(parent.toString() + "'s Direction is in radial mode");
        }
        cardinal.add("up");
    }
    
    public void addDownCardinal() {
        if (!isCardinal) {
            throw new IllegalStateException(parent.toString() + "'s Direction is in radial mode");
        }
        cardinal.add("down");
    }
    
    public void addLeftCardinal() {
        if (!isCardinal) {
            throw new IllegalStateException(parent.toString() + "'s Direction is in radial mode");
        }
        cardinal.add("left");
    }
    
    public void addRightCardinal() {
        if (!isCardinal) {
            throw new IllegalStateException(parent.toString() + "'s Direction is in radial mode");
        }
        cardinal.add("right");
    }
}
