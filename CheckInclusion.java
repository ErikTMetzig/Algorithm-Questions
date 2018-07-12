class CheckInclusion {
    
    public boolean checkInclusion(String s1, String s2) {
        
        //handle bad input
        if(s1 == null || s2 == null || s1.length() > s2.length())
            return false;
        
        //create a hashmap of all characters in s1
        HashMap<Character, Integer> s1Map = new HashMap<Character, Integer>();
    
        for(char c: s1.toCharArray())   {
            
            if(s1Map.containsKey(c))
                s1Map.put(c, s1Map.get(c) + 1);
            else
                s1Map.put(c, 1);
        }
        
        //create hashmap for second string, iterate through with window
        HashMap<Character, Integer> s2Map = new HashMap<Character, Integer>();
        
        //add all initial characters for window of s1's length
        for(int i = 0; i < s1.length(); i++)    {
            
            char ch = s2.charAt(i);
            if(s2Map.containsKey(ch))
                s2Map.put(ch, s2Map.get(ch) + 1);
            else
                s2Map.put(ch, 1);
        }
        
        //iterate through s2 with window, adding and removing characters, check if equal
        for(int j = s1.length(); j < s2.length(); j++)      {
            
            if(s1Map.equals(s2Map))
                return true;
            
            //remove char at front of window
            char ch2 = s2.charAt(j - s1.length());
            if(s2Map.get(ch2) > 1)
                s2Map.put(ch2, s2Map.get(ch2) - 1);
            else
                s2Map.remove(ch2);
            
            //add char at back of window
            char ch3 = s2.charAt(j);
            if(s2Map.containsKey(ch3))
                s2Map.put(ch3, s2Map.get(ch3) + 1);
            else
                s2Map.put(ch3, 1);
        }
        
        return s1Map.equals(s2Map);
    }
}