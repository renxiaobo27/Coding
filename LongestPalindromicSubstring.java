

//5. Longest Palindromic Substring My Submissions QuestionEditorial Solution
//Total Accepted: 115579 Total Submissions: 493049 Difficulty: Medium
//Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
//
//Subscribe to see which companies asked this question
//
//Show Tags
//Show Similar Problems
//


public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return "";
            
        int max = 1;
        String re = s.substring(0,1);
        
        for(int i=0;i<s.length();i++)
        {
            String tmp = help(s,i,i);
            
            if(tmp.length()>re.length())
            {
                re = tmp;
            }
            
            tmp = help(s,i,i+1);
            if(tmp.length()>re.length())
                re = tmp;
        }
        
        return re;
    }
    
    public String help(String s, int b, int e)
    {
        while(b>=0&&e<s.length() && s.charAt(b)==s.charAt(e))
        {
            b--;
            e++;
        }
        
        return s.substring(b+1,e);
    }
}
