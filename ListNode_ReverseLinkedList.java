//Reverse a singly linked list.

public class ListNode_ReverseLinkedList {

	 public ListNode reverseList(ListNode head) {
	        if(head==null || head.next==null)
	            return head;
	        ListNode fakeHead = new ListNode(0);
	        
	        ListNode cur = head;
	        
	        while(cur!=null)
	        {
	            ListNode next = cur.next;
	            cur.next = fakeHead.next;
	            fakeHead.next = cur;
	            cur = next;
	        }
	        return fakeHead.next;
	    }
	    
}
