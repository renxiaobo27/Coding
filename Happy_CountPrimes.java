
public class Happy_CountPrimes {

	public int countPrimes(int n) {
        if(n<=2) return 0;
        
        boolean []visited = new boolean[n];
        
        for(int i=2;i*i<n;i++)
        {
            if(!visited[i])
            {
                 for(int j=i;j*i<n;j++)
                {
                    visited[i*j] = true;
                }
            }
        }
        
        int ct = 0;
        
        for(int i=2;i<n;i++)
        {
            if(!visited[i])
                ct++;
        }
        return ct;
    }
}
