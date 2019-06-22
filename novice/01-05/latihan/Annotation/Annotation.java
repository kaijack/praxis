public class Annotation {

    private String name;
    private int id;

    public Annotation() {
        name = "Java Passion";
    }

    public String getName() {
        return name;
    }

    public void setNme(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object otherName) {
        String newName = (String) otherName;
        int comparisson = name.compareTo(newName);

        return (comparisson == 0);
    }

    public static void main(String[] args) {

    }

}
