public class NextRight {
    
    public void connect(TreeLinkNode root) {
        
        //trivial input
        if(root == null)
            return;
        
        root.next = null;
        
        //recurse to left and right nodes, connecting
        connectHelper(root.left, root.right);
        connectHelper(root.right, null);   
    }
    
    public void connectHelper(TreeLinkNode node1, TreeLinkNode node2)   {
        
        //base case
        if(node1 == null)
            return;
        
        //connect
        node1.next = node2;
        
        //left's next is right
        connectHelper(node1.left, node1.right);
        
        //right's next is parent node's next's left
        if(node2 == null)
            connectHelper(node1.right, null);    
        else
            connectHelper(node1.right, node2.left);
        
    }
}