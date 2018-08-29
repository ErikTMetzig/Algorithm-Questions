class PhoneLetterCombinations {
    
    public List<String> letterCombinations(String digits) {
        
        List<String> retMe = new ArrayList<String>();
        
        //edge case
        if(digits == null || digits.length() == 0)
            return retMe;
        
        //mapping
        char[][] nums = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        
        //create current permutation
        StringBuilder builder = new StringBuilder();
        
        helper(digits, builder, nums, retMe);
        
        return retMe;
    }
    
    public void helper(String original, StringBuilder soFar, char[][] dials, List<String> addToMe)   {
        
        //if this permutation is full length, base case
        if(soFar.length() == original.length())     {
            
            addToMe.add(soFar.toString());
            return;
        }
        
        //get the array we need
        char[] ref = dials[Integer.valueOf("" + original.charAt(soFar.length()))];
        
        //for each character for the number, append, recurse, remove
        for(char c: ref)    {
            
            soFar.append(c);
            helper(original, soFar, dials, addToMe);
            soFar.delete(soFar.length() - 1, soFar.length());
        }
    }
}