//There are N children standing in a line. Each child is assigned a rating value.
//
//You are giving candies to these children subjected to the following requirements:
//
//Each child must have at least one candy.
//Children with a higher rating get more candies than their neighbors.
//What is the minimum candies you must give?
		
//左右问题，两边走
public class Candy_Candy {

	 public int candy(int[] ratings) {
	        if(ratings==null || ratings.length==0)
	            return 0;
	            
	        int[] left = new int[ratings.length];
	        int[] right = new int[ratings.length];
	        left[0] = 1;
	        for(int i=1;i<ratings.length;i++)
	        {
	            if(ratings[i]>ratings[i-1])
	                left[i] = left[i-1]+1;
	            else
	                left[i] = 1;
	        }
	        
	        right[ratings.length-1]= left[ratings.length-1];
	        
	        for(int i=ratings.length-2;i>=0;i--)
	        {
	            if(ratings[i]>ratings[i+1])
	                right[i] = right[i+1] +1;
	            else
	                right[i] = 1;
	        }
	        int max = 0;
	        for(int i=0;i<left.length;i++)
	        {
	            max += Math.max(left[i],right[i]);
	        }
	        return max;
	    }
}
