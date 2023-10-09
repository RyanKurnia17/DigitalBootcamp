package JavaFundamentals;

abstract class Hewan {
    abstract void suara();
}
class Kucing extends Hewan {
    void suara() {
        System.out.println("Meow!");
    }
}
class Anjing extends Hewan {
    void suara() {
        System.out.println("Woof!");
    }
}

class ContohPolimorfisme {
    public static void main(String[] args) {
        Hewan[] hewanArr = new Hewan[2];
        hewanArr[0] = new Kucing();
        hewanArr[1] = new Anjing();
        for (Hewan hewan : hewanArr) {
            hewan.suara(); // Polimorfisme: memanggil metode "suara" pada objek berbeda
        }
    }
}