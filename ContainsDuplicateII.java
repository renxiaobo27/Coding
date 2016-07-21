import java.util.HashMap;

//Given an array of integers and an integer k, 
//find out whether there are two distinct indices i and j 
//in the array such that nums[i] = nums[j] and the difference
//between i and j is at most k.


//思路
//use hashmap record the Integer num, and Index num,
//if same number, we check the two indexes to see whether meet the requirement 
//or not

public class ContainsDuplicateII {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums==null || nums.length==0)
				return false;
		
		HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<nums.length;i++)
		{
			if(map.containsKey(nums[i]))
			{
				if(i-map.get(nums[i])<=k)
					return true;
			}
			map.put(nums[i], i);
		}
		
		return false;
	}
}
