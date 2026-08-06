package binarysearch;

public class KoKoEatingBanana {

    public static void main(String[] args) {
        /*
        piles=[25,10,23,4] h=4
        Output: 25

piles = [30,11,23,4,20], h = 6
Output: 23

         */
        int[] a = { 30,11,23,4,20 };
        int h = 6;
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
    // 25, 10, 23, 4
    // 1,2,3,4,5,...25
    //
}
