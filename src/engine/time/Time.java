package engine.time;

public class Time {
	
    private static long currentTime;
    private static long lastTime;
    
    public static void init() {
        lastTime = getTime();
        currentTime = getTime();
    }
    
    public static void update() {
        lastTime = currentTime;
        currentTime = getTime();
    }
    
    private static long getTime() {
        return System.nanoTime();
    }
    
    public static long getDelta() {
        return currentTime - lastTime;
    }
}
