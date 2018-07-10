class GetBottomLeft {
    
    public int findBottomLeftValue(TreeNode root) {
        
        //handle bad input
        if(root == null)
            return -1;
        
        //initialize two arraylists to do level-order traveral
        ArrayList<TreeNode> l1 = new ArrayList<TreeNode>();
        l1.add(root);
        ArrayList<TreeNode> l2;
        
        //value to be returned
        int left = -1;
        
        //perform level-order traversal, quit when level is empty
        while(l1.size() > 0)    {
            
            left = l1.get(0).val;
            
            //make new array, add values
            l2 = new ArrayList<TreeNode>();
            
            for(TreeNode tr: l1)    {
                
                if(tr.left != null)
                    l2.add(tr.left);
                
                if(tr.right != null)
                    l2.add(tr.right);
            }
            
            //re-assign
            l1 = l2;
        }
        
        return left;
    }
}