class IsSubsequence {
    
    public boolean isSubsequence(String s, String t) {
     
        if((s == null || s.length() == 0) && (t == null || s.length() == 0))
            return true;
        
        if(s.length() > t.length())
            return false;
        
        int posSeen = 0;
        boolean foundThisChar = false;
        
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