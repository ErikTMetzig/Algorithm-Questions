class PathSum {
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        //list to return
        List<List<Integer>> returnMe = new ArrayList<List<Integer>>();
        
        //trivial
        if(root == null)
            return returnMe;
        
        //base case
        if(root.val == sum && root.left == null && root.right == null)  {
            
            List<Integer> addMe = new ArrayList<Integer>();
            addMe.add(root.val);
            returnMe.add(addMe);
        }
        
        //track sum of current path
        int thisPathSum = root.val;
        //use stack to hold all nodes on current path
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        
        //recurse left and right with helper function
        helper(returnMe, thisPathSum, s, root.left, sum);
        helper(returnMe, thisPathSum, s, root.right, sum);
        
        return returnMe;
    }
    
    //takes the list to return, path sum, the current stack, a node, and target sum
    public void helper(List<List<Integer>> passAlong, int sumSoFar, Stack<TreeNode> s, TreeNode root, int target)   {
        
        //trivial
        if(root == null)
            return;
        
        //update stack and sum
        s.push(root);
        sumSoFar += root.val;
        
        //if leaf node and reached sum, put state of stack into list form and add
        if(sumSoFar == target && root.left == null && root.right == null)  {
            
            List<Integer> addMe = new ArrayList<Integer>();
            
            for(TreeNode tr: s)
                addMe.add(tr.val);
            
            passAlong.add(addMe);
        }
        
        //if can recurse left or right
        else    {
            
            helper(passAlong, sumSoFar, s, root.left, target);
            helper(passAlong, sumSoFar, s, root.right, target);
        }
        
        s.pop();
    }
}