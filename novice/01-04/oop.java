class setan {
    String namasetan;
}

class Ciricirisetan extends setan {
    String bentuksetan;
    String warnasetan;

    Ciricirisetan(String namasetan, String bentuksetan, String warnasetan) {
        this.namasetan = namasetan;
        this.bentuksetan = bentuksetan;
        this.warnasetan = warnasetan;
    }

    String resume() {
        return namasetan + " - " + bentuksetan + " - " + warnasetan;
    }
}

class tugassetan extends setan {
    String penghasut;
    String pengganggu;
}

public class oop {

    public static void main(String[] args) {
        Ciricirisetan maklampir = new Ciricirisetan("maklampir", "bulat", "merah");
        System.out.println(maklampir.resume());
    }
}