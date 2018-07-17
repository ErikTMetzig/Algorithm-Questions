class SubarraySumEqualsK {
    
    public int subarraySum(int[] nums, int k) {
        
        //trivial input
        if(nums == null || nums.length == 0)
            return 0;
        
        //use a hashmap to store all previously seen subarray sizes
        HashMap<Integer, Integer> prevSums = new HashMap<Integer, Integer>();
        
        //this sub sum, number of sub sums equal to k
        int currSum = 0;
        int numSubs = 0;
        
        //iterate through array
        for(int i = 0; i < nums.length; i++)    {
            
            //increment thisSum
            currSum += nums[i];
            
            //if this subarray equals target
            if(currSum == k)
                numSubs++;
            
            //if we've already seen any subArraySums that equal the difference
            if(prevSums.containsKey(currSum - k))
                numSubs += prevSums.get(currSum - k);
            
            //put this value in the map
            if(prevSums.containsKey(currSum))
                prevSums.put(currSum, prevSums.get(currSum) + 1);
            else
                prevSums.put(currSum, 1);
        }
        
        return numSubs;
    }
}