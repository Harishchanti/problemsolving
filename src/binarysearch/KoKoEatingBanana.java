package binarysearch;

public class KoKoEatingBanana {

    public static void main(String[] args) {
        /*
        piles=[25,10,23,4]
h=4
         */
        int[] a = { 25, 10, 23, 4 };
        int h = 4;
        System.out.println(minEatingSpeed(a, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        //Arrays.sort(piles);
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        int l = 1, r = max;

        while (l < r) {
            int mid = (l + r) / 2;

            if (canEatBanans(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    static boolean canEatBanans(int[] piles, int mid, int h) {
        int maxhr = 0;

        for (int i : piles) {
            maxhr += i / mid;

            if (i % mid != 0)
                maxhr++;
        }
        return maxhr <= h;
    }
}
