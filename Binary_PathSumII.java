//Given a binary tree and a sum, find all root-to-leaf paths 
//where each path's sum equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
import utility.List
		
public class Binary_PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        if(root==null)
            return re;
        
        help(root,sum,re,new ArrayList<Integer>());
        return re;
    }
    
    public void help(TreeNode root,int sum,List<List<Integer>> re,ArrayList<Integer>tmp)
    {
        if(root==null)
            return ;
        tmp.add(root.val);
        if(sum==root.val && root.left==null && root.right==null)
        {
            re.add(new ArrayList<Integer>(tmp));//no return
           
        }
        
        help(root.left,sum-root.val,re,tmp);
        help(root.right,sum-root.val,re,tmp);
        tmp.remove(tmp.size()-1);
        
        
    }
}
