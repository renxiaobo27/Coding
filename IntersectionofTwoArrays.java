//Given two arrays, write a function to compute their intersection.
//
//Example:
//Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
//
//Note:
//Each element in the result must be unique.
//The result can be in any order.

public class IntersectionofTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        int[] re = new int[nums2.length];
        int k=0;
        for(int num:nums1)
        {
            set.add(num);
        }
        
        for(int num:nums2)
        {
            if(set.contains(num)&&!set2.contains(num))
            {
                re[k++] = num;
                set2.add(num);
            }
        }
        return Arrays.copyOf(re,k);
        
    }
}
