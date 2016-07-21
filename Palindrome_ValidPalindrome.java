//Given a string, determine if it is a palindrome, 
//considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.


public class Palindrome_ValidPalindrome {

	 public boolean isPalindrome(String s) {
	        if(s==null || s.length()==0)
	            return true;
	        int i= 0;
	        int j = s.length()-1;
	        s = s.toLowerCase();
	        
	        while(i<j)
	        {
	            char c1 = s.charAt(i);
	            char c2 = s.charAt(j);
	            
	            while(!valid(c1)&&(i<j))//careful i<j
	            {
	                i++;
	                c1 = s.charAt(i);
	            }
	            
	            while(!valid(c2)&&(i<j))
	            {
	                j--;
	                c2 = s.charAt(j);
	            }
	            
	            if(c1!=c2)
	                return false;
	            i++;
	            j--;
	        }
	        return true;
	    }
	    
	    public boolean valid(char c)
	    {
	        return (c>='a' && c<='z') || (c>='0'&&c<='9');
	    }
}
