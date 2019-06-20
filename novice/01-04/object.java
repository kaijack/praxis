//membuat class dengan nama Hewan
public class Hewan {
    // inisialisasi variabel untuk class Hewan
    int jumlahKaki = 0;
    String namaHewan = "";

    // constructor
    public Hewan(String nama, int kaki) {
        this.jumlahKaki = kaki;
        this.namaHewan = nama;
    }

    // method untuk mengambil info nama dan jumlahkaki
    public void info() {
        System.out.println("Nama Hewan : " + this.namaHewan + ", Kaki : " + this.jumlahKaki);
    }
}
