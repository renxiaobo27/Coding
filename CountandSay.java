//The count-and-say sequence is the sequence of 
//integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.

public class CountandSay {

	 public String countAndSay(int n) {
	        if(n<1)
	            return "";
	        String s = "1";
	        
	        for(int j=0;j<n-1;j++)
	        {
	            StringBuilder sb = new StringBuilder();
	            
	            for(int i=0;i<s.length();i++)
	            {
	                int ct = 1;
	                while(i+1<s.length() && s.charAt(i)==s.charAt(i+1))
	                {
	                    ct++;
	                    i++;
	                }
	                
	                sb.append(String.valueOf(ct)).append(s.charAt(i));
	                
	            }
	            
	            s = sb.toString();
	        }
	        
	        return s;
	    }
}
