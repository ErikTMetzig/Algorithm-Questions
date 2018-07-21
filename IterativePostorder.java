class IterativePostorder {
    
    public List<Integer> postorderTraversal(TreeNode root) {
        
        //list to be returned
        List<Integer> returnMe = new ArrayList<Integer>();
        
        //bad input
        if(root == null)
            return returnMe;
        
        //use one-stack method
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode last = null;
        TreeNode peek = null;
        
        //while we have more nodes to traverse
        while(!s.isEmpty() || curr != null)     {
            
            //iterate through left subtree, like inorder
            if(curr != null)    {
                
                s.push(curr);
                curr = curr.left;
            }
            
            //check if we can recurse right on our node
            else    {
                
                peek = s.peek();
                
                //if can recurse right
                if(peek.right != null && peek.right != last)
                    curr = peek.right;
                
                //otherwise done, add value
                else    {
                    
                    returnMe.add(peek.val);
                    last = s.pop();
                }
            }
        }
        
        return returnMe;
    }
}