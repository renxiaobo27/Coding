//
//Additive number is a string whose digits can form additive sequence.
//
//A valid additive sequence should contain at least three numbers. 
//Except for the first two numbers, each subsequent number in the 
//sequence must be the sum of the preceding two.
//
//For example:
//"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
//
//1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
//"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
//1 + 99 = 100, 99 + 100 = 199
//Note: Numbers in the additive sequence cannot have 
//leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

public class AdditiveNumber {

	 public boolean isAdditiveNumber(String num) {
	        if(num==null || num.length()==0)
	            return false;
	        int L = num.length();
	        
	        for(int i=1;i<=(L-1)/2;i++)//L-1 less one
	        {
	            if(num.charAt(0)=='0' && i>1)
	                break;
	            for(int j=i+1;L-j>=i&&L-j>=j-i;j++)
	            {
	                if(num.charAt(i)=='0' && j>i+1)
	                    break;
	                long part1 = Long.parseLong(num.substring(0,i));
	                long part2 = Long.parseLong(num.substring(i,j));
	                if(help(num.substring(j),part1,part2))
	                    return true;
	            }
	        }
	        
	        return false;
	    }
	    
	    public boolean help(String s, long n1,long n2)
	    {
	        if(s.equals("")) return true;
	        long sum = n1 + n2;
	        String t = String.valueOf(sum);
	        if(s.startsWith(t))
	            return help(s.substring(t.length()),n2,sum);
	        
	        return false;
	    }
}
