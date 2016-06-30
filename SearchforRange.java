//Given a sorted array of integers, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].
//		
		
public class SearchforRange {
	 public int[] searchRange(int[] nums, int target) {
	        int[] re = {-1,-1};
	        
	        if(nums==null || nums.length==0)
	            return re;
	        
	        int i= 0;
	        int j = nums.length-1;
	        int m = 0;
	        
	        while(i<=j)
	        {
	            m = i + (j-i)/2;
	            if(nums[m]==target)
	            {
	                re[0] = m;
	                re[1] = m;
	                break;
	            }
	            else if(nums[m]>target)
	            {
	                j = m - 1;
	            }
	            else
	            {
	                i = m + 1;
	            }
	        }
	        if(re[0]==-1)
	            return re;
	        
	        i = 0;
	        j = re[0];
	        m = 0;
	        
	        while(i<=j)
	        {
	            m = i + (j-i)/2;
	            if(nums[m]==target)
	            {
	                j = m-1;//careful 
	            }
	            else
	            {
	                i = m + 1;
	            }
	        }
	        re[0] = i;//upper boundary
	        
	        i = re[1];
	        j = nums.length-1;
	        m = 0;
	        
	        while(i<=j)
	        {
	            m = i + (j-i)/2;
	            if(nums[m]==target)
	            {
	                i = m+1;
	            }
	            else
	            {
	                j = m-1;
	            }
	        }
	        re[1] = j;//lower boundary
	        return re;
	    }
}
