Given an array of size n, find the majority element. 
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

public class MajorityElement {

	 public int majorityElement(int[] nums) {
	        if(nums==null || nums.length==0)
	            return 0;
	        int cand = nums[0];
	        int ct =1;
	        
	        for(int i=1;i<nums.length;i++)
	        {
	            if(cand==nums[i])
	            {
	                ct++;
	            }
	            else if(ct==0)
	            {
	                ct = 1;
	                cand = nums[i];
	            }
	            else
	            {
	                ct--;
	            }
	        }
	        return cand;
	    }
}
