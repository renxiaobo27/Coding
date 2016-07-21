//Given an integer array of size n, find all elements that appear 
//more than ⌊ n/3 ⌋ times. The algorithm should run
//in linear time and in O(1) space.


//cand1==nums[i]
//cand2==nums[i]
public class MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {
        List<Integer> re = new ArrayList<Integer>();
        if(nums==null || nums.length==0)
            return re;
            
        int cand1 = nums[0];
        int ct1 = 1;
        int cand2 = 0;
        int ct2 = 0;
        
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==cand1)
            {
                ct1++;
            }
            
            else if(nums[i]==cand2)
            {
                ct2++;
            }
            else if(ct1==0)
            {
                cand1 = nums[i];
                ct1 = 1;
            }
            else if(ct2==0)
            {
                cand2 = nums[i];
                ct2 = 1;
            }
            else{
                ct1--;
                ct2--;
            }
        }
        ct1 = 0;
        ct2 = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==cand1)
            {
                ct1++;
            }
            else if(nums[i]==cand2)
            {
                ct2++;
            }
        }
        if(ct1>nums.length/3)
            re.add(cand1);
        if(ct2>nums.length/3)
            re.add(cand2);
        return re;
    }
}
