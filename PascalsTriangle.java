//Given numRows, generate the first numRows of Pascal's triangle.
//
//For example, given numRows = 5,
//Return
//
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
//		
//		
public class PascalsTriangle {

	 public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> re = new ArrayList<List<Integer>>();
	        if(numRows<1) return re;
	        
	        for(int i=0;i<numRows;i++)
	        {
	            ArrayList<Integer> list = new ArrayList<Integer>();
	            list.add(1);
	            if(i==0) 
	            {
	                re.add(list);
	                //continue;
	            }
	            else
	            {
	                for(int j=0;j<re.get(i-1).size()-1;j++)
	            {
	                list.add(re.get(i-1).get(j) + re.get(i-1).get(j+1));
	            }
	                list.add(1);
	            }
	            
	            re.add(list);
	        }
	        return re;
	    }
}



//vector<vector<int>> generate(int numRows) {
//    vector<vector<int>> result;
//    if (numRows <= 0)
//        return result;
//    else
//    {
//        vector<int> temp(1, 1);
//        result.push_back(temp);
//        if (numRows == 1) return result;
//        temp.push_back(1);
//        result.push_back(temp);
//        if (numRows == 2) return result;
//
//        for (int i = 2; i < numRows; ++i)
//        {
//            vector<int> temp(i + 1, 1);
//            for (int j = 1; j < i; ++j)
//                temp[j] = result[i - 1][j - 1] + result[i - 1][j];
//            result.push_back(temp);
//        }
//    }
//    return result;
//}
