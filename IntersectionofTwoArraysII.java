//Given two arrays, write a function to compute their intersection.
//
//Example:
//Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
//
//Note:
//Each element in the result should appear 
//as many times as it shows in both arrays.
//The result can be in any order.
//Follow up:
//What if the given array is already sorted? How would you optimize your algorithm?
//What if nums1's size is small compared to nums2's size? Which algorithm is better?
//What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

		
public class IntersectionofTwoArraysII {
	 public int[] intersect(int[] nums1, int[] nums2) {
	        
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        int[] re = new int[nums2.length];
	        int k = 0;
	        for(int num:nums1)
	        {
	            if(map.containsKey(num))
	            {
	                map.put(num,map.get(num)+1);
	            }
	            else
	            {
	                map.put(num,1);
	            }
	        }
	        
	        for(int num:nums2)
	        {
	            if(map.containsKey(num))
	            {
	                int ct = map.get(num);
	                if(ct>0)
	                {
	                    re[k++] = num;
	                    ct--;
	                    map.put(num,ct);
	                }
	            }
	        }
	        
	        return Arrays.copyOf(re,k);
	        // Arrays.sort(nums1);
	        // Arrays.sort(nums2);
	        // int [] re = new int[nums1.length];
	        
	        // int i=0;
	        // int j =0;
	        // int k = 0;
	        
	        // while(i<nums1.length&&j<nums2.length)
	        // {
	        //     if(nums1[i]==nums2[j])
	        //     {
	        //         re[k++]=nums1[i];
	        //         i++;
	        //         j++;
	        //     }
	        //     else if(nums1[i]<nums2[j])
	        //     {
	        //         i++;
	        //     }
	        //     else
	        //     {
	        //         j++;
	        //     }
	        // }
	        // return Arrays.copyOf(re,k);
	    }

}
