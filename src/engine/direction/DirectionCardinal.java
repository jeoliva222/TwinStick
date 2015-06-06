package engine.direction;

import static engine.direction.Direction.pi;

public class DirectionCardinal {
    
    private static final Cardinal right =     new Cardinal("right",      pi * 0 / 4);
    private static final Cardinal upright =   new Cardinal("upright",    pi * 1 / 4);
    private static final Cardinal up =        new Cardinal("up",         pi * 2 / 4);
    private static final Cardinal upleft =    new Cardinal("upleft",     pi * 3 / 4);
    private static final Cardinal left =      new Cardinal("left",       pi * 4 / 4);
    private static final Cardinal downleft =  new Cardinal("downleft",   pi * 5 / 4);
    private static final Cardinal down =      new Cardinal("down",       pi * 6 / 4);
    private static final Cardinal downright = new Cardinal("downright",  pi * 7 / 4);
    
    private static final Cardinal[] cardinals = {right, upright, up, upleft, left, downleft, down, downright};
    
    private String[] directionString;
    
    public DirectionCardinal() {
        directionString = new String[4];
        reset();
    }
    
    public float getAngle() {
        for (int i = 0; i < cardinals.length; i++) {
            if (this.toString().equals(cardinals[i].toString())) {
                return cardinals[i].getAngle();
            }
        }
        throw new IllegalArgumentException();
    }
    
    public String toString() {
        fix();
        String str = "";
        
        for (int i = 0; i < directionString.length; i++) {
            str += directionString[i];
        }
        
        return str;
    }
    
    public void checkValidity(String d) {
        boolean valid = false;
        
        for (int i = 0; i < cardinals.length; i += 2) {
            if (d.equals(cardinals[i].toString())) {
                valid = true;
            }
        }
        if (!valid) {
            throw new IllegalArgumentException("Passed in string is invalid: " + d);
        }
    }
    
    public final void reset() {
        for (int i = 0; i < directionString.length; i++) {
            directionString[i] = "";
        }
    }
    
    public void set(String d) {
        checkValidity(d);
        reset();
        add(d);
    }
    
    public void set(String d1, String d2) {
        if (d1.equals(d2)) {
            throw new IllegalArgumentException("1st string parameter equals 2nd parameter: " + d1 + " " + d2);
        }
        checkValidity(d1);
        checkValidity(d2);
        reset();
        add(d1);
        add(d2);
    }
    
    public void add(String d) {
        switch (d) {
            case "up":
                directionString[0] = "up";
                break;
            case "down":
                directionString[1] = "down";
                break;
            case "left":
                directionString[2] = "left";
                break;
            case "right":
                directionString[3] = "right";
                break;
            default:
                throw new IllegalArgumentException("Passed in string is invalid: " + d);
        }
    }
    
    public void fix() {
        if ((directionString[0].equals("up") && directionString[1].equals("down"))) {
            directionString[0] = "";
            directionString[1] = "";
        }
        if ((directionString[2].equals("left") && directionString[3].equals("right"))) {
            directionString[2] = "";
            directionString[3] = "";
        }
    }
}
