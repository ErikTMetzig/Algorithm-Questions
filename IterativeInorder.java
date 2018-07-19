class IterativeInorder {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        //list to be returned
        List<Integer> returnMe = new ArrayList<Integer>();
        
        //trivial input
        if(root == null)
            return returnMe;
        
        //use a stack
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        
        //while there are more nodes to see
        while(!s.isEmpty() || curr != null) {
            
            //iterate to bottom-left
            if(curr != null)    {
                
                s.push(curr);
                curr = curr.left;
            }
            
            //if reached bottom left, add value, go right
            else    {
                
                curr = s.pop();
                returnMe.add(curr.val);
                curr = curr.right;
            }
        }
        
        return returnMe;
    }
}