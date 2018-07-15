class IsSubsequence {
    
    public boolean isSubsequence(String s, String t) {
     
        //handle bad input
        if((s == null || s.length() == 0) && (t == null || s.length() == 0))
            return true;
        
        if(s.length() > t.length())
            return false;
        
        int posSeen = 0;
        boolean foundThisChar = false;
        
        //for each char in the first string, must find somewhere in second
        for(char c: s.toCharArray())    {
            
            foundThisChar = false;
            
            //while there's more space to check
            while(posSeen < t.length()) {
                
                //if char is found
                if(t.charAt(posSeen) == c)  {
                    
                    posSeen++;
                    foundThisChar = true;
                    break;
                }
                
                else
                    posSeen++;
            }
            
            //false if can't find the char in order
            if(!foundThisChar)
                return false;
        }
        
        return true;
    }
}
