//
//Given a binary tree, return the inorder traversal of its nodes' values.
//
//For example:
//Given binary tree [1,null,2,3],
//   1
//    \
//     2
//    /
//   3
//return [1,3,2].
		
public class BinaryTreeInorderTraversal {

	 public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> re = new ArrayList<Integer>();
	        
	        if(root==null)
	            return re;
	            
	        Stack<TreeNode> st = new Stack<TreeNode>();
	        TreeNode p = root;
	        
	        while(p!=null || !st.isEmpty())
	        {
	            if(p!=null)
	            {
	                st.push(p);
	                p = p.left;
	            }
	            else
	            {
	                TreeNode tmp = st.pop();
	                re.add(tmp.val);
	                if(tmp.right!=null)
	                    p = tmp.right;
	            }
	        }
	        return re;
	        
	    }
}
