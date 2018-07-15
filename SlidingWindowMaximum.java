class SlidingWindowMaximum {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        //handle bad input
        if(nums == null || nums.length < 1 || k < 1 || k > nums.length)
            return new int[0];
        else if(k == 1)
            return nums;
        
        //the array that we will add all of the maximum values to
        int returnMe[] = new int[nums.length - k + 1];
        int returnMePointer = 0;
        
        //use a double-ended queue to maintain list of integers for window
        Deque<Integer> deq = new LinkedList<Integer>();
        
        //handle the first window, adding each value one by one
        deq.addLast(nums[0]);
        for(int i = 1; i < k; i++)  {
            
            //if bigger than end of window, remove from end
            while((deq.size() > 0) && (deq.peekLast() < nums[i]))
                deq.removeLast();
            
            deq.addLast(nums[i]);
        }
        
        //for every single window
        for(int j = k; j < nums.length; j++)    {
            
            //get the maximum from the last window and add
            returnMe[returnMePointer] = deq.peekFirst();
            returnMePointer++;
            
            //remove the last element if it was still in there
            if(deq.peekFirst() == nums[j - k])
                deq.removeFirst();
            
            //pop all values that are too small compared to new one to add
            while((deq.size() > 0) && (nums[j] > deq.peekLast()))
                deq.removeLast();
            
            deq.addLast(nums[j]);
        }
        
        //add final value and return
        returnMe[returnMePointer] = deq.peekFirst();
        return returnMe;
    }
}