//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//The replacement must be in-place, do not allocate extra memory.
//
//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1

public class Permutation_NextPermutation {

	//从后往前，找第一个不是升序的数字，如果没有（-1）,则说明已经到最后一个permutation，所以直接reverse即可。
    //从后往前，找一个比这个数字大的数字
    //交换这两个数字
    // reverse 第一个数字之后的
    //
    //7 8 6 9 8 7 2
    //7 8 7 9 8 6 2 
    //7 8 7 2 6 8 9
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length==0)
            return;
        int k = -1;
        
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                k = i;
                break;
            }
        }
        if(k==-1)
        {
            reverse(nums,0,nums.length-1);
            return;
        }
        
        int l = -1;
        for(int i=nums.length-1;i>k;i--)
        {
            if(nums[i]>nums[k])
            {
                l = i;
                break;
            }
        }
        
        swap(nums,k,l);
        reverse(nums,k+1,nums.length-1);
    }
    
    public void swap(int[]nums,int i,int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public void reverse(int[]nums,int i,int j)
    {
        int tmp = 0;
        while(i<j)
        {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
