
abstract class Makhluk {
    abstract void berjalan();

    void tidur() {
        System.out.println("kucing sedang tidur");

    }
}

interface Hewan {
    viud makan();

}

class kucing extends Makhluk implements Hewan {

    @Override
    void berjalan() {
        System.out.println("kucing sedang berjalan");
    }

    @Override
    public void makan() {
        System.out.println("kucing sedang makan");
    }
}

public class interAbs {
    public static void public static void main(String[] args) {
        kucing miaw = new Kucing();
        miaw.berjalan();
        miaw.makan();
        miaw.tidur();
    }
}