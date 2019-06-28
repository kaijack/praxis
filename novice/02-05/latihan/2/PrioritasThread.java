
public class PrioritasThread extends Thread {
    private int hitungMundur = 5;
    private volatile double d = 0; // No optimization

    public PrioritasThread(int prioritas) {
        setPriority(prioritas);
        start();
    }

    public void run() {
        while (true) {
            for (int i = 1; i < 100000; i++)
                d = d + (Math.PI + Math.E) / (double) i;
            System.out.println(this.toString() + " : " + hitungMundur);
            if (--hitungMundur == 0)
                return;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new PrioritasThread(Thread.MAX_PRIORITY);
        for (int i = 0; i < 5; i++)
            new PrioritasThread(Thread.MIN_PRIORITY);
    }
}