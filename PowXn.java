//Implement pow(x, n).
//
//Subscribe to see which companies asked this question

//
//递归法
//复杂度
//时间 O(logN) 空间 O(logN)
//
//思路
//通过一点点数学推导我们可以知道，如果n是偶数
//xnxn=x2n
//
//如果n是奇数
//xnxnx=x2n+1
//
//根据这几条原则递归，我们就不用将x相乘n次，而只要logN次就行了
public class PowXn {

	  public double myPow(double x, int n) {
	        if(n<0)
	            return 1/help(x,-n);
	        return help(x,n);
	    }
	    
	    double help(double x,int n)
	    {
	        if(n==0)
	            return 1;
	        double v = help(x,n/2);
	        if(n%2==0)
	            return v*v;
	        return v*v*x;
	    }
}
