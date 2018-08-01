class MinNumCoins {
    
    public int coinChange(int[] coins, int amount) {
        
        //trivial input
        if(coins == null || coins.length == 0)
            return -1;
        if(amount == 0)
            return 0;
        
        //use dynamic programming - one array for min num coins to reach each value
        //other for the last coin used (backtracking)
        int minNumCoins[] = new int[amount + 1];
        int lastCoinUsed[] = new int[amount + 1];
        
        //initialize
        for(int i = 0; i < minNumCoins.length; i++) {
            
            minNumCoins[i] = 100000;
            lastCoinUsed[i] = -1;
        }
        
        minNumCoins[0] = 0;
        
        //for each coin
        for(int j = 0; j < coins.length; j++)   {
            
            int coin = coins[j];
            
            //for each value <= our target
            for(int k = coin; k < minNumCoins.length; k++)  {
                
                //see if coin can be used to minimize number for that value
                if(minNumCoins[k - coin] + 1 < minNumCoins[k])  {
                    
                    minNumCoins[k] = minNumCoins[k - coin] + 1;
                    lastCoinUsed[k] = j;
                }
            }
        }
        
        //if target not reached
        if(lastCoinUsed[amount] == -1)
            return -1;
        
        else
            return minNumCoins[amount];
    }
}