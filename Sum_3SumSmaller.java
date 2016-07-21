import java.util.Arrays;

//
//Given an array of n integers nums and a target, 
//find the number of index triplets i, j, k 
//with 0 <= i < j < k < n that satisfy the 
//condition nums[i] + nums[j] + nums[k] < target.
//
//For example, given nums = [-2, 0, 1, 3], and target = 2.
//
//Return 2. Because there are two triplets which sums are less than 2:
//
//[-2, 0, 1]
//[-2, 0, 3]
//Follow up: Could you solve it in O(n2) runtime?
	
//解题思路和3SUM一样，也是先对整个数组排序，然后一个外层循环确定第一个数，
//然后里面使用头尾指针left和right进行夹逼，得到三个数的和。
//如果这个和大于或者等于目标数，说明我们选的三个数有点大了，
//就把尾指针right向前一位（因为是排序的数组，所以向前肯定会变小）。
//如果这个和小于目标数，那就有right - left个有效的结果。
//为什么呢？因为假设我们此时固定好外层的那个数，还有头指针left指向的数不变，
//那把尾指针向左移0位一直到左移到left之前一位，
//这些组合都是小于目标数的。
public class Sum_3SumSmaller {

	 public int threeSumSmaller(int[] nums, int target) {
		 int ct = 0;
		 
		 Arrays.sort(nums);
		 
		 for(int i=0;i<nums.length;i++)
		 {
			 int left = i+1;
			 int right = nums.length-1;
			 while(left<right)
			 {
				 int sum = nums[i] + nums[left] + nums[right];
				 if(sum>=target)
				 {
					 right--;
				 }
				 else
				 {
					 ct+= right-left;
					 left++;
				 }
			 }
		 }
		 return ct;
	 }
}
