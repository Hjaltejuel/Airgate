package com.airgate;

import java.util.logging.Logger;

public class Robot {

    private LED led;
    private Thread ledThread;
    private LEDRunnable ledRunnable;

    public Robot(){
        this.led = new LED();
        this.ledRunnable = new LEDRunnable();

    }

    private void flipLed(boolean isGreen){
        led.flipLed(isGreen);
        String color = isGreen ? "green" : "red";
        System.out.println("Setting led to : " + color);
    }

    private boolean isDaemonRunning(){
        return !led.isGreen();
    }


    public void openView(){
        if(ledThread != null)
            ledThread.interrupt();
        ledThread = new Thread(ledRunnable,"LEDThread");
        ledThread.start();
    }

    public void closeView(){
        ledThread.interrupt();
        System.out.println("Stopping thread");
    }



    private class LEDRunnable implements Runnable {


        @Override
        public void run() {
            try {
                while(!Thread.interrupted()){
                    flipLed(isDaemonRunning());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                return;
            }
        }

    }
}
