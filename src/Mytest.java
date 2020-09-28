public class Mytest {

    public static void main(String[] args) {

        S d = new S(6);
        d.g = 9;
        S f = new S(20);
        d = f;

        System.out.println(d.g);


    }
}

final class S {
    int g;

    S(int d) {
        g = d;
    }
}