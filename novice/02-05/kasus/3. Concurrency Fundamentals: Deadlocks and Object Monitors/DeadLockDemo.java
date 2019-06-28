// Java program to illustrate Deadlock situation 
class DeadlockDemo extends Thread {
    static Thread mainThread;

    public void run() {
        System.out.println("Child Thread waiting for" + " main thread completion");
        try {

            // Child thread waiting for completion
            // of main thread
            mainThread.join();
        } catch (InterruptedException e) {
            System.out.println("Child thread execution" + " completes");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadlockDemo.mainThread = Thread.currentThread();
        DeadlockDemo thread = new DeadlockDemo();

        thread.start();
        System.out.println("Main thread waiting for " + "Child thread completion");

        // main thread is waiting for the completion
        // of Child thread
        thread.join();

        System.out.println("Main thread execution" + " completes");
    }
}
