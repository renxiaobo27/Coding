//Implement atoi to convert a string to an integer.
//
//Hint: Carefully consider all possible input cases. 
//If you want a challenge, 
//please do not see below and ask yourself what are the possible input cases.
//
//Notes: It is intended for this problem to be specified vaguely 
//(ie, no given input specs). You are responsible to gather all the input requirements up front.
//


public class Integer_StringtoInteger_ATOI {

	public int myAtoi(String str) {
        if(str==null || str.length()==0)
            return 0;
        str = str.trim();
        int res = 0;
        boolean isPos = true;
        
        for(int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
            if(i==0 && (c=='+'||c=='-'))
            {
                isPos = c=='+'?true:false;
            }
            else if(c>='0'&& c<='9')
            {
                //check overflow
                if(res> (Integer.MAX_VALUE-(c-'0'))/10)
                    return isPos? Integer.MAX_VALUE:Integer.MIN_VALUE;
                res = res * 10 + (c-'0');
            }
            else
            {
                return isPos?res:-res;
            }
        }
        return isPos?res:-res;
    }
}
