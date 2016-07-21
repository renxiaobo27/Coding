import java.util.ArrayList;
import java.util.List;

//Given a collection of distinct numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
//		
public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0)  
            return re;
        boolean []visited = new boolean[nums.length];
        
        help(nums,visited,new ArrayList<Integer>(),re);
        return re;
    }
    
    public void help(int[]nums,boolean[]visited,ArrayList<Integer>tmp,List<List<Integer>> re)
    {
        if(tmp.size()==nums.length)
        {
            re.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                tmp.add(nums[i]);
                help(nums,visited,tmp,re);
                visited[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
