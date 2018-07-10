class EditDistance {
    
    public int minDistance(String word1, String word2) {
        
        //no edits for either
        if(word1 == null && word2 == null)
            return 0;
        
        //if only one word is null, edit distance is length of other
        else if(word1 == null)
            return word2.length();
        else if(word2 == null)
            return word1.length();
        
        //must use dynamic programming to solve
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        
        //double-loop, filling in every index of array corresponding to number of edits at that point
        for(int i = 0; i <= word1.length(); i++)    {
            
            for(int j = 0; j <= word2.length(); j++)    {
                
                //handle null rows
                if(i == 0)  {
                    
                    dp[i][j] = j;
                }
                
                else if(j == 0)     {
                    
                    dp[i][j] = i;
                }
                
                //if char is same, no edits needed, same as -1 char length
                else if(word1.charAt(i - 1) == word2.charAt(j - 1))     {
                    
                    dp[i][j] = dp[i - 1][j - 1];
                }
                
                //if different, num of edits is 1 more than the minimum of all adjacent cells
                else    {
                    
                    int min = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    dp[i][j] = min;
                }
            }
        }
        
        //return the edit distance for entire strings
        return dp[word1.length()][word2.length()];
    }
}