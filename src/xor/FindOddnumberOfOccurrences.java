package xor;

public class FindOddnumberOfOccurrences {

    public static void main(String[] args) {

        int[] array = {12, 12, 63, 63, 63, 3, 4, 4, 5, 5};

        findRepeating(array);

    }

    public static void findRepeating(int[] A) {
        int xor = 0;
        for (int i : A) { //o(N)
            xor = xor ^ (1 << i);
        }

        System.out.printf(" ");
        for (int i : A) {//o(N)
            if ((xor & (1 << i)) != 0) { // insertion operator
                System.out.print(i + " ");
                xor = xor ^ (1 << i); // to avoid printing duplicates
            }
        }

    }
}
