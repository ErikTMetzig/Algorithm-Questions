class LowestCommonAncestor {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //base case, either the node is found or null
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        
        //recurse to left and right subtrees
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        
        //if not found
        if(l == null && r == null)
            return null;
        //if foun in right and left subtree
        else if(l != null && r != null)
            return root;
        //if one of the nodes is found, return me
        else if(l != null)
            return l;
        else
            return r;
    }
}