class InsertInterval {
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        //edge cases
        if(newInterval == null)
            return intervals;
        if(intervals == null || intervals.size() == 0)   {
            
            List<Interval> newList = new LinkedList<Interval>();
            newList.add(newInterval);
            return newList;
        }
        
        //convert to linked list for better operations
        LinkedList<Interval> newList = null;
        
        int pos = 0;
        
        //find how many intervals have earlier start times
        for(int i = 0; i < intervals.size(); i++)   {
            
            if(newInterval.start <= intervals.get(i).start)
                break;
            
            pos++;
        }
        
        //handle the intervals predecessor
        //if first pos, nothing to merge before
        if(pos == 0)    {
            
            newList = new LinkedList<Interval>(intervals);
            newList.addFirst(newInterval);
        }
        //if there's some prior interval to merge
        else    {
            
            //if we need to merge
            if(intervals.get(pos - 1).end >= newInterval.start)    {
                
                //if new interval is totally eclipsed by prior, return
                if(newInterval.end <= intervals.get(pos - 1).end)
                    return intervals;
                
                //otherwise if need to update
                else    {
                    
                    newList = new LinkedList<Interval>(intervals);
                    newList.get(pos - 1).end = newInterval.end;
                    pos--;
                }
            }
            
            //add new interval to our list
            else    {
                
                newList = new LinkedList<Interval>(intervals);
                newList.add(pos, newInterval);
            }
        }
        
        //push all valid intervals onto stack
        Stack<Interval> s = new Stack<Interval>();
        Iterator<Interval> it = newList.iterator();
        
        int newCount = 0;
        
        //push all intervals prior to and including our new one onto stack
        while(newCount <= pos)   {
            
            s.push(it.next());
            newCount++;
        }
        
        //iterate through rest of intervals and merge
        while(it.hasNext()) {
            
            //holder
            Interval temp = it.next();
            
            //if don't need to merge anymore, break;
            if(temp.start > s.peek().end)   {
                s.push(temp);
                break;
            }
            else    {
                
                //forget intervals with eclipsed times
                if(temp.end <= s.peek().end)
                    continue;
                
                //otherwise update end, re-push
                else    {
                    
                    Interval temp2 = s.pop();
                    temp2.end = temp.end;
                    s.push(temp2);
                }
            }
        }
        
        //push the rest
        while(it.hasNext())
            s.push(it.next());
        
        
        List<Interval> retMe = new LinkedList<Interval>();
        
        //add the rest
        while(!s.isEmpty())
            retMe.add(0, s.pop());
        
        return retMe;
    }
}