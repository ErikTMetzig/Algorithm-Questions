class Stock2Transactions {
    
    public int maxProfit(int[] prices) {
        
        //trivial
        if(prices == null || prices.length < 2)
            return 0;
        
        //use dynamic programming
        int dp[][] = new int[3][prices.length];
        int maxDiff = 0;
        
        //for each row
        for(int i = 1; i < dp.length; i++)  {
            
            maxDiff = -prices[0];
            
            //for each cell, calculate the maximum difference between buy/sell values, set
            for(int j = 1; j < dp[0].length; j++)   {
                    
                    int thisMax = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                    dp[i][j] = thisMax;
                    
                    maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
                
            }
        }
        
        //return at our target date for 2 transactions
        return dp[2][prices.length - 1];
    }
}