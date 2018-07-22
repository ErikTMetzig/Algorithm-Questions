class IterativeBSTValidation {
    
    public boolean isValidBST(TreeNode root) {
        
        //trivial input
        if(root == null)
            return true;
        
        //perform inOrder traversal, putting the node values in a list
        List<Integer> inOrder = new ArrayList<Integer>();
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        //inorder traversal
        while(!s.isEmpty() || curr != null)     {
            
            //can iterate left
            if(curr != null)    {
                
                s.push(curr);
                curr = curr.left;
            }
            
            //this node's value, iterate right
            else    {
                
                curr = s.pop();
                inOrder.add(curr.val);
                curr = curr.right;
                
                //check elements in arrayList continuously
                if(inOrder.size() == 2)  {
                    
                    if(inOrder.get(0) >= inOrder.get(1))
                        return false;
                    
                    inOrder.remove(0);
                }
            }
        }
        
        //if not, we're good
        return true;
    }
}