class LongestIncreasingSubsequence {
    
    public int lengthOfLIS(int[] nums) {
    
        //handle bad/trivial input
        if(nums == null)
            return 0;
        else if(nums.length == 0 || nums.length == 1)
            return nums.length;
        
        //use dynamic programming - array represents subsequence at that point
        int dp[] = new int[nums.length];
        
        //initialize all values to trivial value
        for(int m = 0; m < dp.length; m++)
            dp[m] = 1;
        
        //for each index of the array
        for(int i = 1; i < nums.length; i++)    {
            
            //backtrack to each index previously seen
            for(int j = 0; j < i; j++)  {
                
                //if ith index is greater than jth index and subsequence at this index must increase
                if((nums[i] > nums[j]) && (dp[i] <= dp[j]))
                    dp[i] = dp[j] + 1;
            }
        }
        
        //find and return max
        int max = 1;
        
        for(int z: dp)
            if(z > max)
                max = z;
        
        return max;
    }
}