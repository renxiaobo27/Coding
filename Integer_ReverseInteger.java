//Example1: x = 123, return 321
//Example2: x = -123, return -321
		
public class Integer_ReverseInteger {

	 public int reverse(int x) {
	        int res = 0;
	        int flag = x>0?1:-1;
	        x = x>0?x:-x;
	        
	        while(x>0)
	        {
	        	//check overflow
	            if((Integer.MAX_VALUE-(x%10))/10<res) return 0;
	            res = res * 10 + (x%10);
	            x /= 10;
	        }
	        
	        return res*flag;
	    }
}
