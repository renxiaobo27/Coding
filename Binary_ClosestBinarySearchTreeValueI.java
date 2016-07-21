//
//复杂度
//时间 O(logN) 空间 O(H)
//
//思路
//根据二叉树的性质，我们知道当遍历到某个根节点时，
//最近的那个节点要么是在子树里面，要么就是根节点本身。
//所以我们根据这个递归，返回子树中最近的节点，和根节点中更近的那个就行了。

public class Binary_ClosestBinarySearchTreeValueI {

	public int closestValue(TreeNode root, double target) {
		int re = root.val;
		
		while(root!=null)
		{
			re = Math.abs(re-target)<Math.abs(root.val-target)?re:root.val;
			root = root.val>target?root.left:root.right;
		}
		return re;
	}
}
