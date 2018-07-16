public class DetectCycle {
    
    public ListNode detectCycle(ListNode head) {
        
        //handle trivial input
        if(head == null || head.next == null)
            return null;
        
        //use fast and slow pointer method
        ListNode slow = head;
        ListNode fast = head;
        
        //if fast encounters null node then no cycle, break
        while(fast.next != null && fast.next.next != null)  {
            
            //increment fast double the pace of slow
            fast = fast.next.next;
            slow = slow.next;
            
            //if cycle found, set slow to head, return where they meet
            if(slow == fast)    {
                
                slow = head;
                
                while(slow != fast)     {
                    
                    slow = slow.next;
                    fast = fast.next;
                }
                
                //start of cycle is where they meet
                return slow;
            }
        }
        
        //no cycle
        return null;
    }
}