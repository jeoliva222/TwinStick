package engine.time;

public class Timer {
	
	private boolean started;
	
	public Timer() {
		
	}
	
	/**
	 * Starts timer.
	 */
	public void start() {
		started = true;
		Time.init();
	}
	
	/**
	 * Restarts timer and @return difference between start time and stop time in nanoseconds.
	 */
	public long stop() {
    	try {
    		if (!started) {
    			throw new TimerNotStartedException();
    		}
	    	Time.update();
	    	return Time.getDelta();
    	} catch (TimerNotStartedException ex) {
    		return 0;
    	}
	}
}

@SuppressWarnings("serial")
class TimerNotStartedException extends Exception {
	
	public TimerNotStartedException() {
		super("Attempted to end timer when it was never started/initialized.");
	}
}
