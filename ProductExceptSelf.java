class ProductExceptSelf {
    
    public int[] productExceptSelf(int[] nums) {
        
        //handle trivial input
        if(nums == null || nums.length == 0)
            return new int[0];
        else if(nums.length == 1)    {
            
            int returnMe[] = new int[1];
            returnMe[0] = 1;
            return returnMe;
        }
        
        //arrray to be returned, intialize all indices
        int returnMe[] = new int[nums.length];
        for(int i = 0; i < returnMe.length; i++)
            returnMe[i] = 1;
        
        //iterate over list storing values of numbers not including self left to right
        int currSum = 1;
        for(int j = 0; j < returnMe.length - 1; j++)    {
            
            currSum *= nums[j];
            returnMe[j + 1] *= currSum;
        }
        
        //go in reverse
        currSum = 1;
        for(int k = nums.length - 1; k > 0; k--)    {
            
            currSum *= nums[k];
            returnMe[k - 1] *= currSum;
        }
        
        return returnMe;
    }
}