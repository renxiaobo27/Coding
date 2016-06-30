//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//You may not alter the values in the nodes, only nodes itself may be changed.
//
//Only constant memory is allowed.
//
//For example,
//Given this linked list: 1->2->3->4->5
//
//For k = 2, you should return: 2->1->4->3->5
//
//For k = 3, you should return: 3->2->1->4->5
		
public class ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null || k==1) return head;
		
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		pre.next = head;
		int i=0;
		while(head!=null)
		{
			i++;
			if(i%k==0)
			{
				ListNode pre = reverse(pre,head.next);
				head = pre.next;
			}
			else
			{
				head = head.next;
			}
		}
		
		return fakeHead.next;
	}
	
	public ListNode reverse(ListNode pre,ListNode next)
	{
		ListNode last = pre.next;
		ListNode cur = last.next;
		
		while(cur!=next)
		{
			ListNode n = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			last.next = n;
			cur = n;
		}
		return last;
	}
}
