
class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
         int n = energyDrinkA.length;
        long[][] dp = new long[n][2];

        // Initialize the first hour: we can start with either drink A or drink B
        dp[0][0] = energyDrinkA[0];
        dp[0][1] = energyDrinkB[0];

        // Fill the dp array for the rest of the hours
        for (int i = 1; i < n; i++) {
            // If we drink A this hour, we could have been drinking A or B last hour
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - energyDrinkB[i - 1]) + energyDrinkA[i];
            // If we drink B this hour, we could have been drinking A or B last hour
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - energyDrinkA[i - 1]) + energyDrinkB[i];
        }

        // The maximum energy boost is the best we can get after n hours, either ending with drink A or B
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
