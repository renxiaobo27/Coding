import java.util.Stack;

//Implement an iterator over a binary search tree (BST). 
//Your iterator will be initialized with the root node of a BST.
//
//Calling next() will return the next smallest number in the BST.
//
//Note: next() and hasNext() should run in average 
//O(1) time and uses O(h) memory, where h is the height of the tree.

public class BinarySearchTreeIterator {

	  Stack<TreeNode> st;
	    public BSTIterator(TreeNode root) {
	        st = new Stack<TreeNode>();
	        
	        while(root!=null)
	        {
	            st.push(root);
	            root = root.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !st.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        if(!st.isEmpty())
	        {
	            TreeNode t = st.pop();
	            TreeNode p = t.right;
	            
	            while(p!=null)
	            {
	                st.push(p);
	                p = p.left;
	            }
	            return t.val;
	        }
	        return 0;
	    }
}
