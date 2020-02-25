package com.airgate;


public class LoadDialog {

    private String text;
    private Thread threadLoading;
    private LoadingRunnable loadingRunnable;

    public LoadDialog(String text){
        this.text = text;
        this.loadingRunnable = new LoadingRunnable();
    }

    public void update(int procent){
        if(loadingRunnable != null)
            loadingRunnable.update(procent);

    }
    public void showDialog(){
        if(threadLoading != null)
            threadLoading.interrupt();
        threadLoading = new Thread(loadingRunnable,"Loading");
        System.out.println("showing dialog");
        threadLoading.start();
    }

    public void closeDialog(){
        threadLoading.interrupt();
        System.out.println("closing dialog");

    }

    private class LoadingRunnable implements Runnable{

        private volatile int procent;

        @Override
        public void run() {
            //Create all the frames and descriptions
            int testProcentage = procent;
            try {
                while(!Thread.interrupted()){
                    if(testProcentage != procent) {
                        System.out.println("done with : " + procent + " procent");
                        testProcentage = procent;
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                return;
            }
        }

        public void update(int procent){
            this.procent = procent;
        }
    }
}
