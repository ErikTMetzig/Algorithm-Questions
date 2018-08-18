class LongestConsecutiveSequence {
    
    public int longestConsecutive(int[] nums) {
        
        //trivial input
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        
        //store all of the integers and if visited
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        
        //put all values in
        for(int i: nums)
            visited.put(i, false);
        
        //longest seen, current sequence
        int longestIncreasing = 1;
        int thisIncreasing = 0;
        
        //get set of keys and iterator
        Set<Integer> values = visited.keySet();
        Iterator<Integer> it = values.iterator();
        
        //for each value
        while(it.hasNext()) {
            
            //store it
            int temp = it.next();
            
            //if we haven't seen this one yet
            if(visited.get(temp) == false)  {
                
                //go as far back as possible smaller than value
                while(visited.containsKey(temp - 1))
                    temp--;
                
                //start counting
                thisIncreasing = 0;
                
                //count this sequence, increasing once each time, marking visited
                while(visited.containsKey(temp))    {
                    
                    thisIncreasing++;
                    visited.put(temp, true);
                    temp++;
                }
    
                //update longest count if necessary
                if(thisIncreasing > longestIncreasing)
                    longestIncreasing = thisIncreasing;
            }
        }
        
        return longestIncreasing;
    }
}