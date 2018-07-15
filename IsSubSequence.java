class IsSubsequence {
    
    public boolean isSubsequence(String s, String t) {
<<<<<<< HEAD
     	
	//handle bad input
=======
     
        //handle bad input
>>>>>>> d381b5907c79e27a547ea682ac81b92d04cbdf3b
        if((s == null || s.length() == 0) && (t == null || s.length() == 0))
            return true;
        
        if(s.length() > t.length())
            return false;
        
        int posSeen = 0;
        boolean foundThisChar = false;
        
<<<<<<< HEAD
	//iterate through each char of first string, must find in second one
=======
        //for each char in the first string, must find somewhere in second
>>>>>>> d381b5907c79e27a547ea682ac81b92d04cbdf3b
        for(char c: s.toCharArray())    {
            
            foundThisChar = false;
            
<<<<<<< HEAD
	
=======
            //while there's more space to check
>>>>>>> d381b5907c79e27a547ea682ac81b92d04cbdf3b
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
