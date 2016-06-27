package relatedTopic;
//Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//For example:
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
    
public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
        if(s==null || s.length()==0)
            return 0;
        int re = 0;
        for(int i=s.length()-1;i>=0;i--)
        {
            re += Math.pow(26,s.length()-1-i) * (int)(s.charAt(i)-'A'+1);// remember to plus 1
        }
        
        return re;
    }
	
	
	public int method2(String s)
	{
		int re = 0;
		
		for(int i=0;i<s.length();i++)
		{
			re = re *26 + s.charAt(i)-'A'+1;
		}
		
		return re;
	}
}

/*
 * class Solution {
public:
    int titleToNumber(string s) {
        int r = 0;
        for (int i = 0; i < s.length(); i ++) {
            r = r * 26 + s[i] - 64;
        }
        return r;
    }
};
 */
