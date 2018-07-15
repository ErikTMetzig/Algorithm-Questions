class topKFrequent {
    
    public List<String> topKFrequent(String[] words, int k) {
        
        //handle bad input
        if(words == null || k < 1)
            return new ArrayList<String>();
        
        //map all words with count
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        
        for(String s: words)    {
            
            if(counter.containsKey(s))
                counter.put(s, counter.get(s) + 1);
            
            else
                counter.put(s, 1);
        }
        
        ArrayList<String> returnMe = new ArrayList<String>();
        
        String maxString = null;
        int maxCount;
        
        //for the number of words that we need
        for(int i = 0; i < k; i++)      {
            
            maxCount = 0;
            
            //do selection of next largest element, remove
            Set<String> keyz = counter.keySet();
            
            for(String st: keyz)    {
                
                if(counter.get(st) > maxCount)  {
                    
                    maxString = st;
                    maxCount = counter.get(st);
                }
                
                else if(counter.get(st) == maxCount)    {
                    
                    if(st.compareTo(maxString) < 0)
                        maxString = st;
                }
            }
            
            //remove and add to our list
            counter.remove(maxString);
            returnMe.add(maxString);
        }
        
        return returnMe;
    }
}