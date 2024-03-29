/*************************************************************************
 *  Stopwatch class to be used as a timer
 *
 *************************************************************************/

public class StopWatch { 

    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    } 

    // return time (in milliseconds) since this object was created
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return now - start;
    } 
    
} 