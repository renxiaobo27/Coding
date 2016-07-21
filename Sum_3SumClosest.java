//Given an array S of n integers, find three integers in
//S such that the sum is closest to a given number, target. 
//Return the sum of the three integers. You may assume that each 
//input would have exactly one solution.
//
//    For example, given array S = {-1 2 1 -4}, and target = 1.
//
//    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//    
public class Sum_3SumClosest {

	public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return 0;
        
        Arrays.sort(nums);
        
        int dist = Integer.MAX_VALUE;
        int re = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            int j = i+1;
            int k = nums.length-1;
            
            while(j<k)
            {
            	int sum = nums[i] + nums[j] + nums[k];
            	int diff = Math.abs(target-sum);
            	if(diff==0) return target;
            	if(diff<dist)
            	{
            		dist = diff;
            		re = sum;
            	}
            	if(sum>target)
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
