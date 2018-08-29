class MaxPathSum {
    
    //max seen so far in whole tree
    int max = Integer.MIN_VALUE;
    //current recursion level
    int level = 0;
    
    public int maxPathSum(TreeNode root) {
        
        //base case
        if(root == null)
            return 0;
        
        //inc recursion level
        level++;
        
        //find the maximum path sum going through left that isn't terminated
        int left = maxPathSum(root.left);
        //same thing for right
        int right = maxPathSum(root.right);
        
        //dec recursion level
        level--;
        
        //max path from this point can either go just through root
        max = Math.max(max, root.val);
        //between children and through root
        max = Math.max(max, root.val + left + right);
        //through just left subtree and root
        max = Math.max(max, root.val + left);
        //or just right subtree and root
        max = Math.max(max, root.val + right);
        
        //the parent node's path can either take a path through this node or through this node and one child
        //or if final iteration, return max seen
        return (level == 0) ? max : Math.max(root.val, root.val + Math.max(left, right));
    }
}