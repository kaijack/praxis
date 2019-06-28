package id.nouval;

import java.lang.Runnable;

public class MultiThread {
    public MultiThread() {
    }

    public static void main(String[] args) {
        new NewThread();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread : " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }

    static class NewThread implements Runnable {
        Thread t;

        NewThread() {
            t = new Thread(this, "Demo Thread");
            System.out.println("Child Thread : " + t);
            t.start();
        }

        public void run() {
            try {
                for (int i = 5; i > 0; i--) {
                    System.out.println("Child Thread : " + i);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                System.out.println("Child interrupted");
            }
            System.out.println("Exiting child thread.");
        }
    }
}