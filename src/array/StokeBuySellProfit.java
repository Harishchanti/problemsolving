package array;

import java.util.ArrayList;
import java.util.List;

public class StokeBuySellProfit {

	class Interval {
		int buy;
		int sell;
	}

	public int oneProfit(int arr[]) {
		int minPrice = arr[0];
		int maxProfit = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - minPrice > maxProfit) {
				maxProfit = arr[i] - minPrice;
			}
			if (arr[i] < minPrice) {
				minPrice = arr[i];
			}
		}
		return maxProfit;
	}

	public int allTimeProfit(int arr[]) {
		int profit = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] < arr[i]) {
				profit += arr[i] - arr[i - 1];

			}
		}
		return profit;
	}

	public static void main(String args[]) {
		int arr[] = { 7, 10, 15, 5, 11, 2, 7, 9, 3 };
		int arr1[] = { 6, 4, 1, 3, 5, 7, 3, 1, 3, 4, 7, 9, 2, 5, 6, 0, 1, 2 };
		//int arr2[] = { 100, 150, 260, 310, 40, 535, 695 };
		StokeBuySellProfit bss = new StokeBuySellProfit();

		System.out.println(bss.oneProfit(arr));
		System.out.println(bss.allTimeProfit(arr1));
		bss.allTimeProfiteTimeIntervel(arr1);

	}

	private void allTimeProfiteTimeIntervel(int[] a) {
		int i = 0;
		int l = a.length;

		if (l == 1) {
			return;
		}
		List<Interval> list = new ArrayList<Interval>();
		while (i < l) {

			while (i < l - 1 && a[i + 1] < a[i]) {
				i++;
			}

			if (i >= l)
				break;

			Interval it = new Interval();
			it.buy = i;

			i++;
			while (i < l && a[i - 1] < a[i]) {
				i++;
			}
			it.sell = i - 1;

			list.add(it);

		}

		for (Interval it : list) {
			System.out.println("buy at : " + it.buy + " sell at : " + it.sell);
		}
	}

}
