
public class Happy_SuperUglyNumber {

	public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1)
            return 1;
        int j=1;
        
        int []index = new int[primes.length];
        int []num = new int[n];
        num[0]=1;
        while(j<n)
        {
            int min = Integer.MAX_VALUE;
            int id = 0;
            for(int i=0;i<primes.length;i++)
            {
                int val = primes[i]*num[index[i]];
                if(val<min)
                {
                    min = val;
                    id = i;
                }
            }
            index[id]++;
            if(num[j-1]!=min)
            {
                num[j++] = min;
            }
        }
        return num[n-1];
    
    }
	
	public static void main(String[]strs)
	{
		Happy_SuperUglyNumber s = new Happy_SuperUglyNumber();
		System.out.println(s.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
	}
}
