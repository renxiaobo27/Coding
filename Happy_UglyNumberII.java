//
//Write a program to find the n-th ugly number.
//
//Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
//
//Note that 1 is typically treated as an ugly number.

public class Happy_UglyNumberII {

	public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int []num = new int[n];
        num[0] = 1;
        int id2 = 0;
        int id3 = 0;
        int id5 = 0;
        
        for(int i=1;i<n;i++)
        {
            int val2 = num[id2]*2;
            int val3 = num[id3]*3;
            int val5 = num[id5]*5;
            
            int min = Math.min(val2,Math.min(val3,val5));
            
            num[i] = min;
            if(val2==min) id2++;
            if(val3==min) id3++;
            if(val5==min) id5++;
        }
        return num[n-1];
    }
}
