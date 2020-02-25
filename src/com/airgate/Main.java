package com.airgate;

import java.util.concurrent.Future;

public class Main {



    public static void main(String[] args) throws InterruptedException {

        onButtonPress();

    }

    public static void testRobot() throws InterruptedException {
        Robot robot = new Robot();
        robot.openView();
        Thread.sleep(5000);
        robot.closeView();
        Thread.sleep(5000);
        robot.openView();
        Thread.sleep(5000);
        robot.closeView();
    }

    public static void onButtonPress() throws InterruptedException {
        LoadDialog dialog = new LoadDialog("Processing data");
        dialog.showDialog();

        final int total = 10000;
        for(int i = 0; i<total; i++){
            double x = ((double) i/(double) total) * 100;

                Thread.sleep(10);

            dialog.update((int) x);
        }

        dialog.closeDialog();
    }




}
