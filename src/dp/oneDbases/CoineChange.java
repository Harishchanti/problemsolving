package dp.oneDbases;

/*
You are given an integer array coins representing coins of different denominations (e.g. 1 dollar, 5 dollars, etc) and an integer amount representing a target amount of money.

Return the fewest number of coins that you need to make up the exact target amount. If it is impossible to make up the amount, return -1.

You may assume that you have an unlimited number of each coin.

Example 1:

Input: coins = [1,5,10], amount = 12

Output: 3
Explanation: 12 = 10 + 1 + 1. Note that we do not have to use every kind coin available.

Example 2:

Input: coins = [2], amount = 3

Output: -1
Explanation: The amount of 3 cannot be made up with coins of 2.

Example 3:

Input: coins = [1], amount = 0

Output: 0
 */
public class CoineChange {
    public static void main(String[] args) {
        int[] coins = {1,2 };
        int amount = 8;
        int result = coinChangeUtil(0, coins, amount);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static int coinChangeUtil(int i, int[] coins, int amount) {
        // base case
        if (amount == 0)
            return 0;
        if (amount < 0 || i == coins.length)
            return Integer.MAX_VALUE;

        int take = Integer.MAX_VALUE;

        // take a coin only if its value
        // is greater than 0.
        if (coins[i] > 0) {
            take =  coinChangeUtil(i, coins, amount - coins[i]);
            if (take != Integer.MAX_VALUE)
                take++;
        }
        // not taking the coins
        int noTake = coinChangeUtil(i + 1, coins, amount);

        return Math.min(take, noTake);
    }
}
