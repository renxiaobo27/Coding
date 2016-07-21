//
//Given a binary search tree, write a function kthSmallest to 
//find the kth smallest element in it.
//
//Note: 
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
//Follow up:
//What if the BST is modified (insert/delete operations) often 
//and you need to find the kth smallest frequently? 
//How would you optimize the kthSmallest routine?


//如果BST节点TreeNode的属性可以扩展，则再添加一个属性leftCnt，
//记录左子树的节点个数
//
//记当前节点为node
//
//当node不为空时循环：
//
//若k == node.leftCnt + 1：则返回node
//
//否则，若k > node.leftCnt：
//则令k -= node.leftCnt + 1，令node = node.right
//否则，node = node.left
//		
public class Binary_KthSmallestElementinBST {

public int kthSmallest(TreeNode root, int k) {
        
        if(root==null ||k<=0) 
            return 0;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(p!=null || !st.isEmpty())
        {
            if(p!=null)
            {
                st.push(p);
                p= p.left;
            }
            else
            {
                TreeNode tmp = st.pop();
                k--;
                if(k==0)
                    return tmp.val;
                if(tmp.right!=null)
                    p = tmp.right;
            }
        }
        return 0;
        
    }

	public static void main(String[]strs)
	{
		int a = 5;
		int b = 4;
		a -= b +1;
		System.out.println(a);
	}
}


