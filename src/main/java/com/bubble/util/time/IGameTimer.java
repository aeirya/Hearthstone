package com.bubble.util.time;

public interface IGameTimer {
    void start();
    void stop();
    void pause();
    void resume();
    Time getTimePassed();
}