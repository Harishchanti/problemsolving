package array;

import java.util.*;

/*
Users make reservations, and I was provided with booking data,
 such as: u1 booked from 10 to 12 u2 booked from 11 to 14 The challenge was to
  find dates where the average number of bookings in the last seven days fell below a certain threshold (e.g., 30% or 60%)
. For example, given this data: 10 -> 1 11 -> 2 12 -> 2 13 -> 1 14 -> 1
 */
public class BookingHoldings {
    /*public static void main(String[] args) {
        int[][] userBooking = { { 10, 12 }, { 11, 16 }, { 9, 18 } };
        Arrays.sort(userBooking, (o, o1) -> {
            return o[0] - o1[0];
        });
        Map<Integer, Integer> countMap = new TreeMap<>();
        int maxCapcity = 0;
        for (int[] a : userBooking) {
            System.out.println(a[0] + " " + a[1]);
            for (int i = a[0]; i <= a[1]; i++) {
                countMap.put(i, countMap.getOrDefault(i, 0) + 1);
                maxCapcity = Math.max(maxCapcity, countMap.get(i));
            }

        }
        //System.out.println("Max capacity : " + maxCapcity);

        System.out.println(countMap.values());

        int window = 7;
        double threshold = 6.0;

       // List<Integer> result = findLowDays(bookings, window, threshold);
        //System.out.println(result);
    }*/

    public static void main(String[] args) {
        int[] bookings = {
                8, 7, 6, 5, 4, 3, 2, 3, 4, 5, 6, 7, 8, 9, 7, 6, 5, 4, 3, 2
        };

        int window = 7;
        double threshold = 6.0;

        List<Integer> result = findLowDays(bookings, window, threshold);
        System.out.println(result);

        Map<Integer, Integer> bookingsv = new TreeMap<>();
        bookingsv.put(10, 1);
        bookingsv.put(11, 2);
        bookingsv.put(12, 2);
        bookingsv.put(13, 1);
        bookingsv.put(14, 1);
        bookingsv.put(15, 1);
        bookingsv.put(16, 2);
        bookingsv.put(17, 1);
        bookingsv.put(19, 2);
        bookingsv.put(20, 4);
        bookingsv.put(23, 8);

        double thresholdv = 3; // example

        List<Integer> resultv = findLowDays(bookingsv, thresholdv);
        System.out.println(resultv);
    }

    public static List<Integer> findLowDays(Map<Integer, Integer> bookings,
            double threshold) {
        List<Integer> days = new ArrayList<>(bookings.keySet());
        List<Integer> result = new ArrayList<>();

        int windowSum = 0;
        int left = 0;

        for (int right = 0; right < days.size(); right++) {
            windowSum += bookings.get(days.get(right));

            if (right - left + 1 > 7) {
                windowSum -= bookings.get(days.get(left));
                left++;
            }

            if (right - left + 1 >= 7) {
                int windowSize = right - left + 1;
                double avg = (double) windowSum / windowSize;

                if (avg < threshold) {
                    result.add(days.get(right));
                }
            }
        }

        return result;
    }

    public static List<Integer> findLowDays(int[] arr, int k,
            double threshold) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (i >= k) {
                sum -= arr[i - k];
            }

            if (i >= k - 1) {
                double avg = (double) sum / k;
                if (avg < threshold) {
                    result.add(i + 1); // day number
                }
            }
        }

        return result;
    }
}
