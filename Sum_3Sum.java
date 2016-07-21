//Given an array S of n integers, are there elements a, b, c 
//in S such that a + b + c = 0? Find all unique triplets in 
//the array which gives the sum of zero.
//
//Note: The solution set must not contain duplicate triplets.
//
//For example, given array S = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
		
public class Sum_3Sum {

	 public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> re = new ArrayList<List<Integer>>();
	        if(nums==null || nums.length==0)
	            return re;
	        Arrays.sort(nums);
	        
	        for(int i=0;i<nums.length;i++)
	        {
	            if(i>0&&nums[i]==nums[i-1]) 
	                continue;
	            int j = i +1;
	            int k = nums.length-1;
	            
	            while(j<k)
	            {
	                int sum = nums[i]+nums[j]+nums[k];
	                if(sum==0)
	                {
	                    ArrayList<Integer> tmp = new ArrayList<Integer>();
	                    tmp.add(nums[i]);
	                    tmp.add(nums[j]);
	                    tmp.add(nums[k]);
	                    re.add(tmp);
	                    j++;
	                    k--;
	                    
	                    while(nums[j]==nums[j-1] && j<k)
	                    {
	                        j++;
	                    }
	                    while(nums[k]==nums[k+1]&&j<k)
	                    {
	                        k--;
	                    }
	                }
	                else if(sum>0)
	                {
	                    k--;
	                }
	                else
	                {
	                    j++;
	                }
	            }
	        }
	        return re;
	    }
}
