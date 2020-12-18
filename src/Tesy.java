public class Tesy  {
    public static void main(String[] args) {

        decrese(2);
    }

    private static void decrese(int i) {

        if(i>=0) {
            decrese(i-1);
        }
        System.out.print("num "+ i);
    }


}
