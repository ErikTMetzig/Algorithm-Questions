class MergeSortLinkedList {
    
    public ListNode sortList(ListNode head) {
        
        //trivial
        if(head == null || head.next == null)
            return head;
        
        //count number of nodes
        ListNode it = head;
        int count = 1;
        
        while(it.next != null)  {
            
            it = it.next;
            count++;
        }
        
        //calculate node for start of recursion call
        count /= 2;
        int count2 = 0;
        it = head;
        
        //find middle
        while(count2 < (count - 1))   {
            
            it = it.next;
            count2++;
        }
        
        //unhook two lists
        ListNode it2 = it.next;
        it.next = null;
        
        //recurse
        ListNode sortedList1 = sortList(head);
        ListNode sortedList2 = sortList(it2);
        
        //if one is null, no need to merge
        if(sortedList1 == null)
            return sortedList2;
        if(sortedList2 == null)
            return sortedList1;
        
        //determine head
        ListNode newHead = null;
        
        //list1 first val is head
        if(sortedList1.val < sortedList2.val)   {
            
            newHead = sortedList1;
            sortedList1 = sortedList1.next;
        }
        
        //otherwise list2 first val is
        else    {
            
            newHead = sortedList2;
            sortedList2 = sortedList2.next;
        }
        
        ListNode insertHere = newHead;
        
        //while we have more nodes to merge
        while(sortedList1 != null || sortedList2 != null)   {
            
            //if end of first list, remainder of second
            if(sortedList1 == null) {
                
                insertHere.next = sortedList2;
                sortedList2 = sortedList2.next;
            }
            
            //if end of second list
            else if(sortedList2 == null)    {
                
                insertHere.next = sortedList1;
                sortedList1 = sortedList1.next;
            }
            
            //first list val is smaller
            else if(sortedList1.val < sortedList2.val)  {
                
                insertHere.next = sortedList1;
                sortedList1 = sortedList1.next;
            }
            
            //second list val is smaller
            else  {
                
                insertHere.next = sortedList2;
                sortedList2 = sortedList2.next;
            }
            
            insertHere = insertHere.next;
        }
        
        return newHead;
    }
}