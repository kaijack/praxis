
public class ThreadDaemon extends Thread {
    public ThreadDaemon() {
        setDaemon(true); // Harus dipanggil sebelum start
        start();
    }

    public void run() {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new ThreadDaemon();
    }

}