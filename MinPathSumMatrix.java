class MinPathSumMatrix {
    
    public int minPathSum(int[][] grid) {
        
        //handle bad input
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        //must use dynamic programming
        int dp[][] = new int[grid.length][grid[0].length];
        
        //for each cell, minimum path is the value of that cell plus minimum of adjacent
        for(int i = 0; i < dp.length; i++)  {
            
            for(int j = 0; j < dp[0].length; j++)   {
                
                //first cell
                if(i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                
                //if at top row, can only draw left
                else if(i == 0)
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                
                //if at left column, can only draw up
                else if(j == 0)
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                
                //distance is cell plus minimum of neighbors
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        //return path at bottom right
        return dp[dp.length - 1][dp[0].length - 1];
    }
}