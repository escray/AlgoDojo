class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        boolean[][] state = new boolean[amount][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            if (amount == coins[i]) {
                return 1;
            }
            if (amount >= coins[i]) {
                state[0][coins[i]] = true;
            }
        }
        for (int i = 1; i < amount; i++) {
            for (int j = 1; j <= amount; j++) {
                if (state[i - 1][j]) {
                    for (int k = 0; k < coins.length; k++) {
                        if (j + coins[k] <= amount) {
                            state[i][j+coins[k]] = true;
                        }
                        if (state[i][amount]) {
                            return i+1;
                        }
                    }
                }
            }
        }
        return -1;


    }
}
