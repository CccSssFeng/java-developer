package com.data.tructure.array.design.模板方法模式;

public abstract class HummerModel {

    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void engineBoom();

    public final void run() {
        this.start();
        this.engineBoom();
        if (this.isAlarm()) {
            this.alarm();
        }
        this.stop();
    }

    protected boolean isAlarm() {
        return true;
    }
}
