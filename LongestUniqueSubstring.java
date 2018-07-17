class LongestUniqueSubstring {
    
    public int lengthOfLongestSubstring(String s) {
        
        //handle trivial input
        if(s == null || s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        
        //use a map of all characters with their last seen position
        HashMap<Character, Integer> mapy = new HashMap<Character, Integer>();
        
        //track current and max sub length
        int maxSubarrayLength = 0;
        int thisSubarrayLength = 0;
        
        //for each character in string
        for(int i = 0; i < s.length(); i++)     {
            
            char c = s.charAt(i);
            
            //if the map doesn't contain char, add it, increase length
            if(!mapy.containsKey(c))    {
                
                mapy.put(c, i);
                thisSubarrayLength++;
                
                //update if new max
                if(thisSubarrayLength > maxSubarrayLength)
                    maxSubarrayLength = thisSubarrayLength;
            }
            
            //otherwise, must remove all characters before the last time this character has been seen
            else    {
                
                //update value to curr pos
                int lastCharIndex = mapy.get(c);
                mapy.put(c, i);
                
                //remove all characters before index
                for(Iterator<Map.Entry<Character, Integer>> it = mapy.entrySet().iterator(); it.hasNext(); ) {
                    
                    Map.Entry<Character, Integer> entry = it.next();
                    
                    if(entry.getValue() < lastCharIndex) {
                    
                        it.remove();
                        thisSubarrayLength--;
                     }
                }
            }
        }
        
        return maxSubarrayLength;
    }
}