package com.bubble.util.time;

public class Time {
    private final long timeMilis;

    public Time() {
        this.timeMilis = 0;
    }

    public Time(long timeMilis) {
        this.timeMilis = timeMilis;
    }

    public Time delta(Time other) {
        return 
            new Time(
                Math.abs(
                  other.timeMilis - this.timeMilis
                )
            );
    }

    public Time sum(Time other) {
        return 
            new Time(
                other.timeMilis + this.timeMilis
            );
    }

    static Time now() {
        return 
            new Time(
                System.currentTimeMillis()   
            );
    }
}