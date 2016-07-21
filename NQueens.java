//
//Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//For example,
//There exist two distinct solutions to the 4-queens puzzle:
//
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
		
//visited【i】 代表在row i，queen的位置

public class NQueens {

	 public List<List<String>> solveNQueens(int n) {
	        List<List<String>> re = new ArrayList<List<String>>();
	        if(n<=0)
	            return re;
	        int[]visited = new int[n];
	        
	        dfs(n,visited,0,re);
	        return re;
	    }
	    
	    public void dfs(int n,int[]visited,int pos, List<List<String>>re)
	    {
	        if(pos==n)
	        {
	            ArrayList<String> tmp = new ArrayList<String>();
	            
	            for(int i=0;i<n;i++)
	            {
	                StringBuilder sb = new StringBuilder();
	                for(int j=0;j<n;j++)
	                {
	                    if(visited[i]!=j)
	                    {
	                        sb.append('.');
	                    }
	                    else
	                    {
	                        sb.append('Q');
	                    }
	                }
	                tmp.add(sb.toString());
	            }
	            re.add(tmp);
	            return ;
	        }
	        
	        for(int i=0;i<n;i++)
	        {
	            visited[pos] = i;
	            if(valid(visited,pos))
	            {
	                dfs(n,visited,pos+1,re);
	            }
	        }
	    }
	    
	    public boolean valid(int[]visited,int pos)
	    {
	        for(int i=0;i<pos;i++)
	        {
	            if(visited[i]==visited[pos] || Math.abs(visited[i]-visited[pos])==pos-i)
	                return false;
	        }
	        return true;
	    }
}
