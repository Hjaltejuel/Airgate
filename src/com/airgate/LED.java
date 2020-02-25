package com.airgate;

public class LED {
    private boolean isGreen;

    public void flipLed(boolean isGreen){
        this.isGreen = isGreen;
    }

    public boolean isGreen() {
        return isGreen;
    }
}
