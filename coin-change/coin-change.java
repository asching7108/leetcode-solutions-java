class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount + 1]);
    }
    
    private int coinChange(int[] coins, int amount, int[] count) {
        if (amount == 0) return 0;
        int res = amount + 1;
        for (int coin : coins) {
            if (amount >= coin) {
                int rem = amount - coin;
                if (count[rem] == 0) {
                    count[rem] = coinChange(coins, rem, count);
                }
                if (count[rem] > -1) {
                    res = Math.min(res, count[rem] + 1);
                }
            }
        }
        return res > amount ? -1 : res;
    }
}