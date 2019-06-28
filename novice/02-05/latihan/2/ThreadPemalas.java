
class ThreadPemalas extends Thread {
    private int waktu;

    public ThreadPemalas(String namaThread, int waktuTidur) {
        super(namaThread);
        waktu = waktuTidur;
        start();
    }

    public void run() {
        try {
            sleep(waktu);
        } catch (InterruptedException e) {
            System.out.println(getName() + " dibangunkan. " + "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " sudah bangun.");
    }
}

class ThreadPenggabung extends Thread {
    private ThreadPemalas sleeper;

    public ThreadPenggabung(String namaThread, ThreadPemalas pemalas) {
        super(namaThread);
        this.sleeper = pemalas;
        start();
    }

    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getName() + " selesai setelah " + sleeper.getName());
    }
}

public class JoinDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        ThreadPemalas brr = new ThreadPemalas("brr", 2000);
        ThreadPemalas grr = new ThreadPemalas("grr", 2000);

        ThreadPenggabung saya = new ThreadPenggabung("saya", brr);
        ThreadPenggabung anda = new ThreadPenggabung("anda", grr);

        grr.interrupt();
    }

}