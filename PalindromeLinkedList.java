//Given a singly linked list, determine if it is a palindrome.
//
//Follow up:
//Could you do it in O(n) time and O(1) space?
		
public class PalindromeLinkedList {

	 public boolean isPalindrome(ListNode head) {
	        if(head==null || head.next==null)
	            return true;
	        ListNode mNode = getMid(head);
	        ListNode half = mNode.next;
	        mNode.next = null;
	        ListNode rNode = reverse(half);
	        
	        while(rNode!=null)
	        {
	            if(rNode.val!=head.val)
	                return false;
	            rNode = rNode.next;
	            head = head.next;
	        }
	        return true;
	    }
	    public ListNode getMid(ListNode head)
	    {
	        ListNode fast = head.next;
	        ListNode slow = head;
	        
	        while(fast!=null&&fast.next!=null)
	        {
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        return slow;
	    }
	    
	    public ListNode reverse(ListNode head)
	    {
	        ListNode fakeHead = new ListNode(0);
	        
	        while(head!=null)
	        {
	            ListNode next = head.next;
	            head.next = fakeHead.next;
	            fakeHead.next = head;
	            head = next;
	        }
	        return fakeHead.next;
	    }
}
