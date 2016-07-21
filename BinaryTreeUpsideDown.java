//Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
//
//For example:
//Given a binary tree {1,2,3,4,5},
//1
/// \
//2 3
/// \
//4 5
//
//return the root of the binary tree [4,5,2,#,#,3,1].
//4
/// \
//5 2
//  / \
// 3 1
// 

//必须画图，然后可以发现，作为任何的node， all left children nodes are roots. 
//n = n.left, then, n.left=parent.right; n.right=parent;

public class BinaryTreeUpsideDown {

	public TreeNode UpsideDownBinaryTree(TreeNode root) {
		TreeNode n = root;
		TreeNode parent = null;
		TreeNode parentRight = null;
		
		while(n!=null)
		{
			TreeNode next = n.left;
			n.left = parentRight;
			parentRight = n.right;
			n.right = parent;
			parent = n;
			n = next;
		}
		return parent;
	}
}
