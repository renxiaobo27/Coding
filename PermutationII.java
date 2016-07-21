import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
//		
public class PermutationII {

	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0)
            return re;
        Arrays.sort(nums);
        boolean [] visited = new boolean[nums.length];
        
        help(nums,new ArrayList<Integer>(),visited,re);
        return re;
        
    }
    
    public void help(int[]nums,ArrayList<Integer>tmp,boolean[]visited,List<List<Integer>>re)
    {
        if(tmp.size()==nums.length)
        {
            re.add(new ArrayList<Integer>(tmp));
            return ;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
            if(!visited[i])
            {
                tmp.add(nums[i]);
                visited[i] = true;
                help(nums,tmp,visited,re);
                visited[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
