public class Transaksi extends Costumer implements Barang {
    private int kodeBarang;
    private String namaBarang;
    private float harga;

    private int kodeTransaksi;
    private int banyak;

    // konstruktor
    public Transaksi() {
    }

    // dari kelas parent
    public Transaksi(int noId, String nama, String alamat) {
        super(noId, nama, alamat);
    }

    public void setTransaksi(int kodeTransaksi, int banyak) {
        this.kodeTransaksi = kodeTransaksi;
        this.banyak = banyak;
    }

    // total transaksi = banyaknya barang * harga barang
    public float totalTransaksi() {
        return (banyak * harga);
    }

    // override class interface
    public void setBarang(int kodeBarang, String namaBarang, float harga) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
    }

    // output
    public void cetakStruk() {
        System.out.println("ID Pembeli          : " + super.getNoId());
        System.out.println("Nama Pembeli                : " + super.getNama());
        System.out.println("Alamat                      : " + super.getAlamat());

        System.out.println("Kode Barang                 : " + kodeBarang);
        System.out.println("Nama Barang                 : " + namaBarang);
        System.out.println("Harga                       : " + harga);

        System.out.println("Kode transaksi              : " + kodeTransaksi);
        System.out.println("Banyak                      : " + banyak);

        System.out.println("Total Transaksi     : " + totalTransaksi());
    }

}