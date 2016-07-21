//Given a sorted linked list, delete all duplicates 
//such that each element appear only once.
//
//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.
		
public class RemoveDuplicatesfromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null)
				return head;
		ListNode fakeHead = new ListNode(0);
		ListNode pre= fakeHead;
		ListNode cur = head;
		
		while(cur!=null)
		{
			while(cur.next!=null&&cur.val==cur.next.val)
			{
				cur = cur.next;
			}
			pre.next = cur;
			pre = pre.next;
			cur = cur.next;
		}
		
		return fakeHead.next;
	}
}
