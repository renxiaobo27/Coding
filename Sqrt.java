//Implement int sqrt(int x).
//
//Compute and return the square root of x.
//		
	

//复杂度
//time: O(logn), space: O(1)
public class Sqrt {
	
	 public int mySqrt(int x) {
	        
	        
	        long i = 0;
	        long j = x;
	        long m;
	        
	        while(i<=j)
	        {
	            m = i + (j-i)/2;
	            long s = m*m;
	            if(x==s) return (int)m;
	            else if(x>s) i=m+1;
	            else j = m-1;
	        }
	        
	        return (int)j;
	    }

}

//Follow up
//Implement double sqrt(double x, int p)
//如果结果是res, 必须满足res*res与x直到小数点后p位结果都相同。
//同样用Binary Search解决，但要注意精确度，为了符合条件，可以直接将两个结果分别乘以10的p次方，看两者结果整数部分是否相等。

//public class Solution {
//    public double sqrt(double num, int p) {
//        double i = 0;
//        double j = num;
//        double mid = 0;
//        while(i <= j) {
//            mid = i + (j - i) / 2.0;
//            int curVal = (int) (mid * mid * Math.pow(10, p));
//            int nextVal = (int) (num * Math.pow(10, p));
//            if (curVal == nextVal)
//                break;
//            if (mid * mid > num) {
//                j = mid;
//            } else {
//                i = mid;
//            }
//        }
//        return mid;
//    }
//}