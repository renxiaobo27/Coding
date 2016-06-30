//Given an array nums, write a function to move all 0's to the 
//end of it while maintaining the relative order of the non-zero elements.
//
//For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//
//Note:
//You must do this in-place without making a copy of the array.
//Minimize the total number of operations.


public class MoveZeroes {

	public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0)
            return ;
        int i = 0;
        int b = 0;
        int e = nums.length;
        
        while(b<e)
        {
            if(nums[b]!=0)
            {
                nums[i] = nums[b];
                i++;
            }
            b++;
        }
        
        for(;i<nums.length;i++)
        {
            nums[i] = 0;
        }
    }
}
