Follow up for N-Queens problem.

Now, instead outputting board configurations, 
return the total number of distinct solutions.


public class NQueensII {

	 public int ct = 0;
	    public int totalNQueens(int n) {
	        int[]visited = new int[n];
	        dfs(n,visited,0);
	        return ct;
	    }
	    
	    public void dfs(int n,int[]visited,int pos)
	    {
	        if(pos==n)
	        {
	            ct++;
	            return;
	        }
	        
	        for(int i=0;i<n;i++)
	        {
	            visited[pos]=i;
	            if(valid(visited,pos))
	            {
	                dfs(n,visited,pos+1);
	            }
	        }
	    }
	    
	    public boolean valid(int []visited,int pos)
	    {
	        for(int i=0;i<pos;i++)
	        {
	            if(visited[i]==visited[pos]|| Math.abs(visited[i]-visited[pos])==pos-i)
	                return false;
	        }
	        return true;
	    }
}
