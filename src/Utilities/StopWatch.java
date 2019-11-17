package Utilities;

public class StopWatch {

    private long start;
    private long timeElapsed;

    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        timeElapsed += System.currentTimeMillis() - start;
    }

    public void reset() {
        timeElapsed = 0;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }
}
