class MaxEachRow {
    
    public List<Integer> largestValues(TreeNode root) {
    
        List<Integer> returnMe = new ArrayList<Integer>();
        
        //handle bad input
        if(root == null)
            return returnMe;
        
        //use two arraylists to perform level-order traversal
        ArrayList<TreeNode> l1 = new ArrayList<TreeNode>();
        l1.add(root);
        ArrayList<TreeNode> l2;
        
        //perform level-order traversal, adding max of each row
        while(l1.size() > 0)    {
            
            int thisRowMax = Integer.MIN_VALUE;
            l2 = new ArrayList<TreeNode>();
            
            //iterate through level
            for(TreeNode tr: l1)    {
                
                if(tr.val > thisRowMax)
                    thisRowMax = tr.val;
                
                if(tr.left != null)
                    l2.add(tr.left);
                if(tr.right != null)
                    l2.add(tr.right);
            }
            
            //add max
            returnMe.add(thisRowMax);
            l1 = l2;
        }
        
        return returnMe;
    }
}