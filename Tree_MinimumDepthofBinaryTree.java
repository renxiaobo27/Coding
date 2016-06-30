//
//111. Minimum Depth of Binary Tree My Submissions QuestionEditorial Solution
//Total Accepted: 112607 Total Submissions: 363336 Difficulty: Easy
//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the 
//root node down to the nearest leaf node.

public class Tree_MinimumDepthofBinaryTree {
	
	 public int minDepth(TreeNode root) {
	        if(root==null)
	            return 0;
	        if(root.left==null) //如果左边为空，则走右边
	            return minDepth(root.right)+1;
	        if(root.right==null)//右边为空 ， 走左边
	            return minDepth(root.left)+1;
	        return Math.min(minDepth(root.left),minDepth(root.right))+1;
	    }

}
