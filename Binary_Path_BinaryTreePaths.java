//Given a binary tree, return all root-to-leaf paths.
//
//For example, given the following binary tree:
//
//   1
// /   \
//2     3
// \
//  5
//All root-to-leaf paths are:
//
//["1->2->5", "1->3"]
		
public class Binary_Path_BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
        List<String> re = new ArrayList<String>();
        if(root==null)
            return re;
        
        help(root,new StringBuilder(),re);
        return re;
    }
    
    public void help(TreeNode root,StringBuilder sb,List<String> re)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
        {
            sb.append(root.val);
            re.add(sb.toString());
            return;
        }
        
        sb.append(root.val+"->");
        
        help(root.left,new StringBuilder(sb),re);
        help(root.right,new StringBuilder(sb),re);
    }
}

//Method 2
//public List<String> binaryTreePaths(TreeNode root) {
//    List<String> res = new ArrayList<String>();
//    if (root == null) {
//        return res;
//    }
//    String str = root.val +"";
//    helper(res, root, str);
//    return res;
//}
//public void helper(List<String> res, TreeNode root, String str) {
//    if (root.left == null && root.right == null) {
//        res.add(str);
//        return;
//    }
//    if (root.left != null) {
//        helper(res, root.left, str + "->" + root.left.val);
//    }
//    if (root.right != null) {
//        helper(res, root.right, str +"->" + root.right.val);
//    }
