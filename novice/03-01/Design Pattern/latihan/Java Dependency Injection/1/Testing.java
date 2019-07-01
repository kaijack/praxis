public class Testing {
    public static void main(String[] args) {
        Koneksi objKoneksi = new Koneksi();

        AutoNumber autoNumber = new AutoNumber(); // Setter Injection
        autoNumber.setObjKoneksi(objKoneksi);
        autoNumber.printAutoNumber();
    }
}