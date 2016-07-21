//Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
//
//Example 1:
//nums = [1, 3], n = 6
//Return 1.
//
//Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
//Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
//Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
//So we only need 1 patch.
//
//Example 2:
//nums = [1, 5, 10], n = 20
//Return 2.
//The two patches can be [2, 4].
//
//Example 3:
//nums = [1, 2, 2], n = 5
//Return 0.


//那么此时我们能表示的范围是[0, miss)，
//表示此时我们能表示0到miss-1的数，如果此时的num <= miss，
//那么我们可以把我们能表示数的范围扩大到[0, miss+num)，
//如果num>miss，那么此时我们需要添加一个数，为了能最大限度的增加表示数范围，
//我们加上miss它本身

public class PatchingArray {

	 public int minPatches(int[] nums, int n) {
		 long miss = 1;//careful long overflow
		 int i=0;
		 int ct = 0;
		 
		 while(miss<=n)
		 {
			 if(i<nums.length&&miss>=nums[i])
			 {
				 miss += nums[i];
			 }
			 else // else include i exceed the length
			 {
				 miss += miss;
				 ct++;
			 }
		 }
		 return ct;
	 }
}
