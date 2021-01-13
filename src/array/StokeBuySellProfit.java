package array;

import java.util.ArrayList;
import java.util.List;
// https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/

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


		int k = 3;
		int price[] = {12, 14, 17, 10, 14, 13, 12, 15};

		int n = price.length;

		System.out.println("Maximum profit with K transctions is: " +
				maxProfit(price, n, k));

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
	static int maxProfit(int price[],
						 int n, int k)
	{

		// table to store results of subproblems
		// profit[t][i] stores maximum profit
		// using atmost t transactions up to day
		// i (including day i)
		int profit[][] = new int[k + 1][ n + 1];

		// For day 0, you can't earn money
		// irrespective of how many times you trade
		for (int i = 0; i <= k; i++)
			profit[i][0] = 0;

		// profit is 0 if we don't do any
		// transation (i.e. k =0)
		for (int j = 0; j <= n; j++)
			profit[0][j] = 0;

		// fill the table in bottom-up fashion
		for (int i = 1; i <= k; i++)
		{
			int prevDiff = Integer.MIN_VALUE;
			for (int j = 1; j < n; j++)
			{
				prevDiff = Math.max(prevDiff,
						profit[i - 1][j - 1] -
								price[j - 1]);
				profit[i][j] = Math.max(profit[i][j - 1],
						price[j] + prevDiff);
			}
		}

		return profit[k][n - 1];
	}

	// Driver code


}
