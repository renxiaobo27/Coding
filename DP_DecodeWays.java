//A message containing letters from A-Z is being encoded to 
//numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, 
//determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.
//


//state: dp[i]表示前i个字符的总共decode的可能性
//function：
//如果第i个字符(substring[i-1,i] )可以被decode， dp[i] = dp[i-1]
//如果i-1, i字符（substring[i-2,i-1]）可以decode， dp[i] += dp[i-1]
//inital: dp[0] = 1 因为当长度为2时候找第二种情况就等于dp[0]， 此时应该为1而不是0
//dp[1] = 0 或者1 之所以要定义dp[1]因为我们要判定i-2的情况 所以单独列出来
//return dp[s.length()]
public class DP_DecodeWays {

	 public int numDecodings(String s) {
	        if(s==null || s.length()==0)
	            return 0;
	        int []dp = new int[s.length()+1];
	        dp[0] = 1;
	        if(valid(s.substring(0,1)))
	        {
	            dp[1] = 1;
	        }
	        
	        for(int i=2;i<=s.length();i++)
	        {
	            if(valid(s.substring(i-2,i)))
	                dp[i] += dp[i-2];
	            if(valid(s.substring(i-1,i)))
	                dp[i] += dp[i-1];
	        }
	        
	        return dp[s.length()];
	    
	    }
	    
	    public boolean valid(String s)
	    {
	        if(s.charAt(0)=='0') //careful this 
	            return false;
	        int val = Integer.parseInt(s);
	        return val>0&&val<=26;
	    }
}
