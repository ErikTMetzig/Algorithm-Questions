class OddEvenLinkedList {
    
    public ListNode oddEvenList(ListNode head) {
        
        //edge cases
        if(head == null || head.next == null || head.next.next == null)
            return head;
    
        //pointers
        ListNode evenStart = head.next;
        ListNode oddP = head;
        ListNode evenP = head.next;
        boolean oddGoes = true;
        
        //while we haven't reached end, do bunny-jump
        while(oddP != null && evenP != null)    {
            
            //if odd turn
            if(oddGoes) {
                
                oddP.next = evenP.next;
                oddP = oddP.next;
            }
            
            //if even turn
            else    {
                
                evenP.next = oddP.next;
                evenP = evenP.next;
            }
            
            oddGoes = !oddGoes;
        }
        
        //link two lists
        oddP = head;
        
        while(oddP.next != null && oddP.next != evenP)
            oddP = oddP.next;
        
        oddP.next = evenStart;
        
        return head;
    }
}