package Lab23_Thievery;

import java.util.HashMap;

public class Thievery {

    static final int W = 10;
    static int[] weights = {6, 1, 2, 5, 4, 3};
    static int[] values = {10, 5, 7, 12, 8, 6};

    public static void main(String[] args) {
        System.out.println(maxValue(new int[weights.length + 1][W+1]));
    }

    public static int maxValue(int[][] dp) {
        for (int item = 0; item < dp.length; item++) {
            for (int weight = 0; weight < dp[item].length; weight++) {
                if (item == 0) {
                    dp[item][weight] = 0;
                    continue;
                }
                if (weights[item-1] <= weight) {
                    int take = values[item - 1] + dp[item - 1][weight - weights[item - 1]];
                    dp[item][weight] = Math.max(take, dp[item-1][weight]);
                } else {
                    dp[item][weight] = dp[item-1][weight];
                }
            }
        }
        return dp[dp.length- 1][dp[0].length - 1];
    }

}
