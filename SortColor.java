//Given an array with n objects colored red, white or blue, 
//sort them so that objects of the same color are adjacent, 
//with the colors in the order red, white and blue.
//
//Here, we will use the integers 0, 1, and 2 to represent the color red, 
//white, and blue respectively.
//
//Note:
//You are not suppose to use the library's sort function for this problem.

public class SortColor {

	 public void sortColors(int[] nums) {
	        if(nums==null || nums.length==0)
	            return;
	            
	        int i= 0;
	        int j = nums.length-1;
	        int k = j;
	        
	        while(i<=j)
	        {
	            if(nums[i]==2)
	            {
	                nums[i] = nums[k];
	                nums[k] = 2;
	                k--;
	                if(k<j)
	                    j = k;
	            }
	            else if(nums[i]==1)
	            {
	                nums[i] = nums[j];
	                nums[j] = 1;
	                j--;
	            }
	            else
	            {
	                i++;
	            }
	            
	        }
	    }
}
