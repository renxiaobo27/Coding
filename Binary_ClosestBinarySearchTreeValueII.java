import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Binary_ClosestBinarySearchTreeValueII {

	 public List<Integer> closestKValues(TreeNode root, double target, int k) {
		 Queue<Integer> list =new LinkedList<Integer>();
		 Stack<TreeNode> st = new Stack<TreeNode>();
		 
		 while(root!=null)
		 {
			 st.push(root);
			 root = root.left;
		 }
		 
		 while(!st.isEmpty())
		 {
			 TreeNode tmp = st.pop();
			 if(list.size()<k)
			 {
				 list.add(tmp.val);
			 }
			 else
			 {
				// 队列到k时，判断下新的数是否更近，更近就加入队列并去掉队头
				 int top = list.peek();
				 if(Math.abs(tmp.val-target) <Math.abs(top-target))
				 {
					 list.poll();
					 list.add(tmp.val);
				 }
				 else
				 {
					 // 如果不是更近则直接退出，后面的数只会更大
					 break;
				 }
			 }
			 
			 TreeNode r = tmp.right;
			 while(r!=null)
			 {
				 st.push(r);
				 r = r.left;
			 }
		 }
		 
		// 强制转换成List，是用LinkedList实现的所以可以转换
		 return (List<Integer>) list;
	 }
}
