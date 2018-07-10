class RightSideView {
    
    public List<Integer> rightSideView(TreeNode root) {
        
        //arraylist representing view
        List<Integer> returnMe = new ArrayList<Integer>();
        
        //handle bad input
        if(root == null)
            return returnMe;
        
        //declare two arraylists for level-order traversal, add root
        ArrayList<TreeNode> l1 = new ArrayList<TreeNode>();
        l1.add(root);
        ArrayList<TreeNode> l2;
        
        //perform level-order traversal, only quitting when last level is empty
        while(l1.size() > 0)    {
            
            //add value on far left of level
            returnMe.add(l1.get(l1.size() - 1).val);
            
            l2 = new ArrayList<TreeNode>();
            
            //add all of each node's children
            for(TreeNode tr: l1)    {
                
                if(tr.left != null)
                    l2.add(tr.left);
                
                if(tr.right != null)
                    l2.add(tr.right);  
            }
            
            //next level
            l1 = l2;
        }
        
        return returnMe;
    }
}