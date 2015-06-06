package engine.time;

public class Delay {
    
    private int length;
    private long endTime;
    boolean started;
    
    public Delay(float lengthInSeconds) {
        this.length = (int) (lengthInSeconds * 1000);
        started = false;
    }
    
    public void start() {
        started = true;
        endTime = length * 1000000 + Time.getTime();
    }
    
    public void reset() {
        started = false;
    }
    
    public void forceEnd() {
        started = false;
        endTime = 0;
    }
    
    public boolean isOver() {
        if (!started) {
            return true;
        }
        return (Time.getTime() >= endTime);
    }
}
