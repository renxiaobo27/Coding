//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//return 1->4->3->2->5->NULL.
//
//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.

public class ReverseLinkedListII {

	 public ListNode reverseBetween(ListNode head, int m, int n) {
	        if(head==null || head.next==null)   
	            return head;
	        
	        ListNode fakeHead = new ListNode(0);
	        
	        ListNode pre = fakeHead;
	        
	        pre.next = head;
	        int ct = 1;
	        while(pre.next!=null&&ct<m)
	        {
	            pre = pre.next;
	            ct++;
	        }
	        if(ct!=m) return head;
	        
	        ListNode mNode = pre.next;
	        ListNode cur = mNode.next;
	        while(ct<n && cur!=null) //ct<n cur.next = nNode
	        {
	            ListNode next = cur.next;
	            cur.next = pre.next;
	            pre.next = cur;
	            mNode.next = next;
	            cur = next;
	            ct++;
	        }
	        return fakeHead.next;
	    }
}
