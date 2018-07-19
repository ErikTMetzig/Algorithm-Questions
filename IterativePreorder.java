class IterativePreorder {
    
    public List<Integer> preorderTraversal(TreeNode root) {
     
        //list to be returned
        List<Integer> returnMe = new ArrayList<Integer>();
        
        //bad input
        if(root == null)
            return returnMe;
        
        //use stack and holder node
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode curr = null;
        
        //for each node, add value, push right, push left
        while(!s.isEmpty()) {
            
            curr = s.pop();
            returnMe.add(curr.val);
            
            if(curr.right != null)
                s.push(curr.right);
            if(curr.left != null)
                s.push(curr.left);
        }
        
        return returnMe;
    }
}