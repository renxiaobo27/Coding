import java.util.ArrayList;
import java.util.List;

//
//Given a binary tree, imagine yourself standing on the right side of it, 
//return the values of the nodes you can see ordered from top to bottom.
//
//For example:
//Given the following binary tree,
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
//You should return [1, 3, 4].
		
//using one queue, every time get the top element, push the root.right first		
public class Tree_BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> re = new ArrayList<Integer>();
        if(root==null) return re;
        Queue<TreeNode> list = new LinkedList<TreeNode>();
        
        list.add(root);
        while(list.size()>0)
        {
            int size = list.size();
            for(int i=0;i<size;i++)
            {
                TreeNode tmp = list.poll();
                if(i==0)
                {
                    re.add(tmp.val);
                }
                if(tmp.right!=null)
                    list.add(tmp.right);
                if(tmp.left!=null)
                    list.add(tmp.left);
                    
            }
        }
        return re;
    }
}
