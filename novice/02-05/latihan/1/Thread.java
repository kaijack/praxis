package id.nouval;

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

    static class NewThread extends Thread {
        NewThread() {
            super("Demo Thread");
            System.out.println("Child Thread : " + this);
            start();
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