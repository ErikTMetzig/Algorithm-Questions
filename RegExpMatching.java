class RegExpMatching {
    
    public boolean isMatch(String s, String p) {
    
        //edge cases
        if(s == null && p == null)
            return true;
        if(s == null ^ p == null)
            return false;
        
        //use dynamic programming
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        //empty string and pattern works
        dp[0][0] = true;
        
        //handle patterns that require no string
        for(int i = 1; i < dp[0].length; i++)
            if(p.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 2];
        
        //for each row of our dp array
        for(int k = 1; k <= s.length(); k++)    {
            
            //for each column
            for(int m = 1; m <= p.length(); m++)  {
                
                //if using dot operator for pattern or char and pattern match at this index
                if(p.charAt(m - 1) == '.' || (s.charAt(k - 1) == p.charAt(m - 1)))
                    dp[k][m] = dp[k - 1][m - 1];
                
                //otherwise for the star operator
                else if(p.charAt(m - 1) == '*') {
                    
                    //could go back two spots to not have any occurrences of previous pattern char
                    if(dp[k][m - 2] == true)
                        dp[k][m] = true;
                    
                    //otherwise try one or more instances of the previous pattern char
                    else if(p.charAt(m - 2) == '.' || (s.charAt(k - 1) == p.charAt(m - 2)))
                        dp[k][m] = dp[k - 1][m];
                    
                }
                
                else
                    dp[k][m] = false;
            }
        }
        
        //return result of full stirng and pattern
        return dp[s.length()][p.length()];
    }
}