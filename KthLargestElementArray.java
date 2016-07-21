//Find the kth largest element in an unsorted array. 
//Note that it is the kth largest element in the sorted order, 
//not the kth distinct element.
//
//For example,
//Given [3,2,1,5,6,4] and k = 2, return 5.
		
public class KthLargestElementArray {

	 public int findKthLargest(int[] nums, int k) {
	        if(nums==null || nums.length==0)
	            return 0;
	        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	        
	        for(int num:nums)
	        {
	            q.offer(num);
	            if(q.size()>k)
	                q.poll();
	        }
	        return q.peek();
	    }
	 
	 
	 /**********************************/
	 public int findKthLargest2(int[] nums, int k) {
	        if(nums==null || nums.length==0)
	            return 0;
	       return help(nums,0,nums.length-1,nums.length-k);
	    }
	    
	    public int help(int[]nums,int i,int j,int k)
	    {
	        if(i>=j) return nums[i];
	        
	        int m = partition(nums,i,j);
	        
	        if(m==k) return nums[k];
	        else if(m>k) return help(nums,i,m-1,k);
	        else return help(nums,m+1,j,k);
	    }
	    
	    public int partition(int[]nums,int i,int j)
	    {
	        int x = nums[i];
	        int k = i+1;
	        int p = i;
	        
	        while(k<=j)
	        {
	            if(nums[k]<=x)
	            {
	                swap(nums,++p,k);
	            }
	            k++;
	        }
	        
	        swap(nums,p,i);
	        return p;
	        
	    }
	    
	    public void swap(int[]nums,int i,int j)
	    {
	        int tmp = nums[i];
	        nums[i] =nums[j];
	        nums[j] = tmp;
	    }
}



