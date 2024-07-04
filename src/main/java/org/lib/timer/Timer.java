package org.lib.timer;

public class Timer {
  private long startTime, endTime;
  private boolean isRunning = false;

  public Timer() {}

  public void start() {
    isRunning = true;
    this.startTime = System.currentTimeMillis();
  }

  public void reset() {
    if (isRunning) {
      this.startTime = System.currentTimeMillis();
    }
  }

  public long get() {
    return (isRunning) ? startTime : endTime;
  }

  public void stop() {
    if (isRunning) {
      this.startTime = System.currentTimeMillis();
      isRunning = false;
    }
  }

}
