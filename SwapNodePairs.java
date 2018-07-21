class SwapNodePairs {
    
    public ListNode swapPairs(ListNode head) {
     
        //handle bad input
        if(head == null || head.next == null)
            return head;
        
        //recursively flip the next pair
        ListNode returnMe = head.next;
        ListNode nextFlipStart = head.next.next;
        
        //flip
        returnMe.next = head;
        head.next = swapPairs(nextFlipStart);
        
        return returnMe;
    }
}