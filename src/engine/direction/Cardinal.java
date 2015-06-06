package engine.direction;

public class Cardinal {
    
    private String directionString;
    private float angle;
    
    public Cardinal(String d, float a) {
        directionString = d;
        angle = a;
    }
    
    @Override
    public String toString() {
        return this.directionString;
    }
    
    public float getAngle() {
        return this.angle;
    }
}
