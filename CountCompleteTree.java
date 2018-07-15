class CountCompleteTree {
    
    public int countNodes(TreeNode root) {
        
        //handle standard input
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return 1;
        else if(root.right == null)
            return 2;
        
        //if length all the way to the right is same as left, complete
        else if(leftCount(root) == rightCount(root))     {
            
            int returnVal = (int)Math.pow(2, leftCount(root)) - 1;
            
            return returnVal;   
        }
        
        //recurse
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    
    //iterate to the very bottom left of the root and return count
    public int leftCount(TreeNode root) {
        
        if(root == null)
            return 0;
        else if(root.left == null)
            return 1;
        
        TreeNode temp = root.left;
        int result = 2;
        
        while(temp.left != null)    {
            
            temp = temp.left;
            result++;
        }
        
        return result;
    }
    
    //iterate to the bottom right of root and return count
    public int rightCount(TreeNode root)    {
        
        if(root == null)
            return 0;
        else if(root.right == null)
            return 1;
        
        TreeNode temp = root.right;
        int result = 2;
        
        while(temp.right != null)    {
            
            temp = temp.right;
            result++;
        }
        
        return result;
    }
}