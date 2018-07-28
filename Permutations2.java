class Permutations2 {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
     
        //list of lists to return
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        
        //trivial input
        if(nums == null || nums.length == 0)
            return permutations;
        
        //map each unique integer in input to its count
        TreeMap<Integer, Integer> intCounts = new TreeMap<Integer, Integer>();
        
        for(int i: nums)    {
            
            if(!intCounts.containsKey(i))
                intCounts.put(i, 1);
            
            else
                intCounts.put(i, intCounts.get(i) + 1);
        }
        
        //iterate through keys
        Set<Integer> keys = intCounts.keySet();
        Iterator<Integer> it = keys.iterator();
        
        //create arrays of all unique ints and their counts
        int values[] = new int[keys.size()];
        int counts[] = new int[keys.size()];
        int pointer = 0;
        
        //fill them in
        while(it.hasNext()) {
            
            int temp = it.next();
            values[pointer] = temp;
            counts[pointer] = intCounts.get(temp);
            pointer++;
        }
        
        //holds current permutation being traced
        List<Integer> perm = new ArrayList<Integer>();
        
        //use helper function to recursively generate permuations
        int targetLength = nums.length;
        helper(values, counts, perm, permutations, 0, targetLength);
        
        return permutations;   
    }
    
    public void helper(int values[], int counts[], List<Integer> perm, List<List<Integer>> addToMe, int count, int targetLength)  {
        
        //if reached base case where current permuation is full, add it
        if(count == targetLength)   {
            
            addToMe.add(new ArrayList<Integer>(perm));
            return;
        }
        
        //otherwise find first available character from left, add it, recurse
        else    {
            
            for(int k = 0; k < counts.length; k++)  {
                
                //if available
                if(counts[k] > 0)   {
                    
                    //add, decrement, recurse, restore
                    perm.add(values[k]);
                    counts[k]--;
                    helper(values, counts, perm, addToMe, count + 1, targetLength);
                    perm.remove(perm.size() - 1);
                    counts[k]++;
                }
            }
        }
    }
}