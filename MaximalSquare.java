class MaximalSquare {
    
    public int maximalSquare(char[][] matrix) {
        
        //handle bad input
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        //use dynamic programming
        int dp[][] = new int[matrix.length][matrix[0].length];
        int max = 0;
        
        //for each row
        for(int i = 0; i < matrix.length; i++)  {
            
            //for each column
            for(int j = 0; j < matrix[0].length; j++)   {
                
                //if a zero, set to zero in dynamic array
                if(matrix[i][j] == '0')     {
                    
                    dp[i][j] = 0;
                }
                
                //otherwise set it to 1 + min of all adjacent cells
                else    {
                    
                    int up = 0;
                    int diag = 0;
                    int left = 0;
                    
                    if(i > 0)
                        up = dp[i - 1][j];
                    
                    if((i > 0) && (j > 0))
                        diag = dp[i - 1][j - 1];
                    
                    if(j > 0)
                        left = dp[i][j - 1];
                    
                    dp[i][j] = Math.min(Math.min(up, diag), left) + 1;
                    
                    //new max
                    if(dp[i][j] > max)
                        max = dp[i][j];
                        
                }
            }
        }
        
        return max * max;
    }
}