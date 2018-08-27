class SumRootToLeaf {
    
    public int sumNumbers(TreeNode root) {
        
        //make a referable integer to store sum
        int[] result = new int[1];
        
        //cal helper
        sumNumbers(root, result, 0);
        
        return result[0];
    }
    
    //helper function to recrusively calculate sum
    public void sumNumbers(TreeNode root, int[] result, int sumSoFar)    {
        
        //base case, nothing to add
        if(root == null)
            return;
        
        //increment number with new node
        int newNum = sumSoFar * 10;
        newNum += root.val;
        
        //if we're at the end, add the sum
        if(root.left == null && root.right == null)
            result[0] += newNum;
        
        //otherwise recurse left and right
        else    {
            
            sumNumbers(root.left, result, newNum);
            sumNumbers(root.right, result, newNum);
        }
    }
}