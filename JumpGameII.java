//
//Given an array of non-negative integers, 
//you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length 
//at that position.
//
//Your goal is to reach the last index in the minimum number of jumps.
//
//For example:
//Given array A = [2,3,1,1,4]
//
//The minimum number of jumps to reach the last index is 2. 
//(Jump 1 step from index 0 to 1, then 3 steps to the last index.)
//


public class JumpGameII {

	 public int jump(int[] nums) {
	        if(nums==null || nums.length==0)
	            return 0;
	        int lastcover = 0;
	        int cover = 0;
	        int step = 0;
	        
	        for(int i=0;i<nums.length&&i<=cover;i++)
	        {
	            if(i>lastcover)
	            {
	                step++;
	                lastcover = cover;
	            }
	            if(i+nums[i]>cover)
	            {
	                cover = i+nums[i];
	            }
	        }
	        if(cover<nums.length-1)
	            return 0;
	        return step;
	    }
}
