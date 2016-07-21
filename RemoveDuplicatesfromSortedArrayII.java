//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//
//For example,
//Given sorted array nums = [1,1,1,2,2,3],
//
//Your function should return length = 5, 
//with the first five elements of nums 
//being 1, 1, 2, 2 and 3. It 
//doesn't matter what you leave beyond the new length.

public class RemoveDuplicatesfromSortedArrayII {

	public int removeDuplicates(int[] nums) {
		if(nums==null||nums.length==0)
				return 0;
		if(nums.length==1)
				return 1;
		
		int end = 1;
		int j = end+1;
		
		while(j<nums.length)
		{
			if(nums[j]!=nums[end-1])
			{
				nums[++end] = nums[j];
			}
			j++;
		}
		return end+1;
	}
	
	public static void main(String[]strs)
	{
		RemoveDuplicatesfromSortedArrayII r = new RemoveDuplicatesfromSortedArrayII();
		int[]nums ={1};
		System.out.println(r.removeDuplicates(nums));
	}
}
