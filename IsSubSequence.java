class IsSubsequence {
    
    public boolean isSubsequence(String s, String t) {
     	
	//handle bad input
        if((s == null || s.length() == 0) && (t == null || s.length() == 0))
            return true;
        
        if(s.length() > t.length())
            return false;
        
        int posSeen = 0;
        boolean foundThisChar = false;
        
	//iterate through each char of first string, must find in second one
        for(char c: s.toCharArray())    {
            
            foundThisChar = false;
            
	
            while(posSeen < t.length()) {
                
                if(t.charAt(posSeen) == c)  {
                    
                    posSeen++;
                    foundThisChar = true;
                    break;
                }
                
                else
                    posSeen++;
            }
            
            if(!foundThisChar)
                return false;
        }
        
        return true;
    }
}