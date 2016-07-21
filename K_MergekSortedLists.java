
public class K_MergekSortedLists {

	  public ListNode mergeKLists(ListNode[] lists) {
	        if(lists==null||lists.length==0)
	            return null;
	        
	        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>()
	        {
	            public int compare(ListNode n1,ListNode n2)
	            {
	                return n1.val - n2.val;
	            }
	            });
	            
	        for(ListNode l:lists)
	        {
	            if(l!=null)
	                q.offer(l);
	        }
	        ListNode dummy = new ListNode(0);
	        ListNode pre = dummy;
	        while(!q.isEmpty())
	        {
	            ListNode n = q.poll();
	            pre.next = n;
	            pre = pre.next;
	            if(n.next!=null)
	            {
	                q.offer(n.next);
	            }
	        }
	        
	        return dummy.next;
	    }
}
