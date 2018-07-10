class ZigZagLevels {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       
        //list to return
        List<List<Integer>> returnMe = new ArrayList<List<Integer>>();
        
        //handle bad input
        if(root == null)
            return returnMe;
        
        //initialize arraylists for level-order traversal
        ArrayList<TreeNode> l1 = new ArrayList<TreeNode>();
        l1.add(root);
        ArrayList<TreeNode> l2;
        
        //holds direction to go in list
        boolean right = true;
        
        //perform level-order traversal
        while(l1.size() > 0)    {
            
            List<Integer> addMe = new ArrayList<Integer>();
            
            //add nodes to right
            if(right)   {
                
                for(int i = 0; i < l1.size(); i++)  {
                    
                    addMe.add(l1.get(i).val);
                }
            }
            
            //otherwise add to left
            else   {
                
                for(int i = l1.size() - 1; i >= 0; i--)  {
                    
                    addMe.add(l1.get(i).val);
                }
            }
            
            //add list to return
            returnMe.add(addMe);
            
            l2 = new ArrayList<TreeNode>();
            
            //do level-order traversal
            for(TreeNode tr: l1)    {
                
                if(tr.left != null)
                    l2.add(tr.left);
                if(tr.right != null)
                    l2.add(tr.right);
            }
            
            l1 = l2;
            right = !right;
        }
        
        return returnMe;
    }
}