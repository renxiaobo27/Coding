//You are given two linked lists representing two non-negative numbers. 
//The digits are stored in reverse order and each of their nodes 
//contain a single digit. Add the two numbers and return it as a linked list.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8

public class Intege_AddTwoNumbers {

	  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        if(l1==null && l2==null) return null;
	        if(l1!=null && l2==null) return l1;
	        if(l1==null && l2!=null) return l2;
	        ListNode fakeHead = new ListNode(0);
	        ListNode pre = fakeHead;
	        int c = 0;
	        int val1,val2;
	        while(l1!=null || l2!=null ||c!=0)
	        {
	            val1 = l1==null?0:l1.val;
	            val2 = l2==null?0:l2.val;
	            int val = val1+ val2 + c;
	            ListNode n = new ListNode(val%10);
	            pre.next = n;
	            pre = pre.next;
	            
	            c = val /10;
	            if(l1!=null)
	                l1 = l1.next;
	            if(l2!=null)
	                l2 = l2.next;
	        }
	        
	        return fakeHead.next;
	    }
}
