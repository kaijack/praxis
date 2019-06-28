
// Kelas dalam bernama
class KelasDalamBernama {
    private int hitungMundur = 5;
    private Dalam dalam;

    // Kelas Dalam adalah kelas dalam (inner class) yang
    // merupakan kelas turunan kelas Thread
    private class Dalam extends Thread {
        Dalam(String nama) {
            super(nama);
            start();
        }

        public void run() {
            while (true) {
                System.out.println(getName() + " : " + hitungMundur);
                if (--hitungMundur == 0)
                    return;
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    } // akhir Dalam

    // Konstruktor KelasDalamBernama
    // Membuat objek baru yang merupakan instansi kelas Dalam
    public KelasDalamBernama(String nama) {
        dalam = new Dalam(nama);
    }
} // akhir KelasDalamBernama

// Kelas dalam anonim
class KelasDalamAnonim {
    private int hitungMundur = 5;
    private Thread t;

    // Konstruktor KelasDalamAnonim
    public KelasDalamAnonim(String nama) {
        // Kelas anonim turunan Thread
        t = new Thread(nama) {
            public void run() {
                while (true) {
                    System.out.println(getName() + " : " + hitungMundur);
                    if (--hitungMundur == 0)
                        return;
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }; // akhir kelas anonim
        t.start();
    }
} // akhir KelasDalamAnonim

// Kelas dalam implementasi runnable bernama
class KelasRunnableBernama {
    private int hitungMundur = 5;
    private Dalam dalam;

    // Kelas Dalam adalah kelas dalam (inner class) yang
    // merupakan kelas yang mengimplementasi Runnable
    private class Dalam implements Runnable {
        Thread t;

        Dalam(String nama) {
            t = new Thread(this, nama);
            t.start();
        }

        public void run() {
            while (true) {
                System.out.println(t.getName() + " : " + hitungMundur);
                if (--hitungMundur == 0)
                    return;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    } // akhir kelas Dalam

    // Konstruktor KelasRunnableBernama
    // Membuat objek baru yang merupakan instansi kelas Dalam
    public KelasRunnableBernama(String nama) {
        dalam = new Dalam(nama);
    }
} // akhir KelasRunnableBernama

// Kelas dalam implementasi runnable anonim
class KelasRunnableAnonim {
    private int hitungMundur = 5;
    private Thread t;

    public KelasRunnableAnonim(String nama) {
        t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " : " + hitungMundur);
                    if (--hitungMundur == 0)
                        return;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }, nama); // akhir kelas dalam anonim
        t.start();
    }
} // akhir KelasRunnableAnonim

// Menjalankan thread dari dalam metode dan kelas anonim
class ThreadViaMetode {
    private int hitungMundur = 5;
    private Thread t;
    private String nama;

    public ThreadViaMetode(String nama) {
        this.nama = nama;
    }

    public void runThread() {
        if (t == null) {
            // Definisi kelas anonim dari dalam metode
            t = new Thread(nama) {
                public void run() {
                    while (true) {
                        System.out.println(getName() + " : " + hitungMundur);
                        if (--hitungMundur == 0)
                            return;
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }; // akhir kelas dalam anonim
            t.start();
        }
    }
} // akhir ThreadViaMetode

public class VariasiThread {
    public static void main(String[] args) {
        new KelasDalamBernama("KelasDalamBernama");
        new KelasDalamAnonim("KelasDalamAnonim");
        new KelasRunnableBernama("KelasRunnableBernama");
        new KelasRunnableAnonim("KelasRunnableAnonim");
        new ThreadViaMetode("ThreadViaMetode").runThread();
    }
}