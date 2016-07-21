//
//这道题给了BST和p，找p的后继，两种情况：
//
//p有右孩子：后继为右孩子的最左孩子
//p无右孩子：后继为离它最近的第一个大于他的爹，他的爹中如果没有大于它的，返回Null

public class Binary_InorderSuccessorInBST {

	 public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		 if(p.right!=null)
		 {
			 return findMostLeft(p.right);
		 }
		 else
		 {
			 TreeNode succ = null;
			 while(root!=p) // path to p
			 {
				 if(root.val<p.val)
				 {
					 root = root.right;
				 }
				 else
				 {
					 succ = root;
					 root = root.left;
				 }
			 }
			 return succ;
		 }
	 }
	 
	 public TreeNode findMostLeft(TreeNode root)
	 {
		 while(root.left!=null)
		 {
			 root = root.left;
		 }
		 return root;
	 }
}
