package relatedTopic;
//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//For example:
//
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
    
    
public class ExcelSheetColumnNumber2 {

	public String convertToTitle(int n) {
		if(n<1) return "";
		StringBuilder sb = new StringBuilder();
		
		while(n>0)
		{
			n--;
			sb.insert(0, (char)(n%26+'A'));
			n /= 26;
		}
		
		return sb.toString();
	
	}
}
/*
class Solution {
public:
    string convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        return convertToTitle((n - 1) / 26) + (char)((n - 1) % 26 + 'A');
    }
};



public:
    string convertToTitle(int n) {
        string r = "";
        while (n > 0) {
            r = (char)(65 + (n - 1) % 26) + r;
            n = (n - 1) / 26;
        }
        return r;
    }
};
*
*
*
*
*/
