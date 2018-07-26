class StockKTransactions {
    
    public int maxProfit(int k, int[] prices) {
        
        //trivial input
        if(prices == null || prices.length < 2)
            return 0;
        
	//if we can always buy
        if(k >= prices.length / 2)  {
            
            int profit = 0;
            
            for(int m = 0; m < prices.length - 1; m++)
                if(prices[m] < prices[m + 1])
                    profit += (prices[m + 1] - prices[m]);
            
            return profit;
        }
        
        //use dynamic programming
        int dp[][] = new int[k + 1][prices.length];
        
        //iterate through all rows (excluding 0 - k == 0 means no transactions or profit)
        for(int i = 1; i <= k; i++)  {

            //max difference seen in this row between a profit and stock price for that day
            int maxDiff = -prices[0];
            
            //for each sell day
            for(int j = 1; j < prices.length; j++)  {
                
                //max profit is either not transacting or price + the maximum difference seen
                dp[i][j] = Math.max(dp[i][j - 1], maxDiff + prices[j]);
                
                //update max if necessary
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        
        //return best profit
        return dp[k][prices.length - 1];
    }
}