//Trapping Rain Water My Submissions QuestionEditorial Solution
//Total Accepted: 70676 Total Submissions: 215260 Difficulty: Hard
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//For example, 
//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
//		
public class Candy_Water {

	 public int trap(int[] height) {
	        if(height==null || height.length==0)
	            return 0;
	        int []left = new int[height.length];
	        int []right = new int[height.length];
	        
	        int maxLeft = height[0];
	        for(int i=1;i<height.length-1;i++)
	        {
	            if(height[i]>maxLeft)
	            {
	                left[i] = height[i];
	                maxLeft = height[i];
	            }
	            else
	            {
	                left[i] = maxLeft;
	            }
	        }
	        
	        int rightMax = height[height.length-1];
	        
	        for(int i= height.length-2;i>=1;i--)
	        {
	            if(height[i]>rightMax)
	            {
	                rightMax = height[i];
	                right[i] = height[i];
	            }
	            else
	            {
	                right[i] = rightMax;
	            }
	        }
	        
	        int area = 0;
	        int sum = 0;
	        for(int i=1;i<=height.length-1;i++)
	        {
	            sum = Math.min(right[i],left[i]) - height[i];
	            if(sum>0)
	                area += sum;
	        }
	        return area;
	    }
}
