import java.util.ArrayList;
import java.util.List;

//Given an index k, return the kth row of the Pascal's triangle.
//
//For example, given k = 3,
//Return [1,3,3,1].

//     1
//   1 1
//   1 2 1
//  1 3 3 1
// 1 4 6 4 1


public class PascalsTriangleII {

	 public List<Integer> getRow(int rowIndex) {
	        List<Integer> re = new ArrayList<Integer>();
	        
	        for(int i=0;i<=rowIndex;i++)
	        {
	            re.add(0);
	        }
	        
	        for(int i=0;i<=rowIndex;i++)
	        {
	            re.set(i,1);
	            for(int j=i-1;j>0;j--)
	            {
	                re.set(j,re.get(j) + re.get(j-1));
	            }
	        }
	        
	        return re;
	    }
}
