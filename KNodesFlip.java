class KNodesFlip {
    
    public ListNode reverseKGroup(ListNode head, int k)     {
        
        //handle bad input
        if(head == null || head.next == null || k < 2)
            return head;
        
        //iterate to end of this flip, simply return if can't flip
        ListNode it = head;
        int count = 1;
        
        while(count < k)    {
            
            if(it.next == null)
                return head;
            
            it = it.next;
            count++;
        }
        
        //hold node at start of next iteration
        ListNode nextStart = null;
        if(it.next != null)
            nextStart = it.next;
        
        //holder nodes to do flipes
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next;
        
        //flip all in this cycle
        while(curr != it)    {
            
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        //re-assign head, flip next cycle
        curr.next = prev;
        head.next = reverseKGroup(nextStart, k);
        
        return curr;
    }
}