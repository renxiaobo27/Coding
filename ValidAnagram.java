//Given two strings s and t, write a function to determine if t is an anagram of s.
//
//For example,
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.
		
public class ValidAnagram {

	 public boolean isAnagram(String s, String t) {
	        if(s==null&&t==null)  return true;
	        if(s==null || t==null) return false;
	        if(s.length()!=t.length()) return false;
	        
	        int[]ct = new int[256];
	        
	        for(int i=0;i<s.length();i++)
	        {
	            int c1 = (int)(s.charAt(i)-'0');
	            int c2 = (int)(t.charAt(i)-'0');
	            
	            ct[c1]++;
	            ct[c2]--;
	        }
	        
	        for(int i=0;i<256;i++)
	        {
	            if(ct[i]!=0)
	                return false;
	        }
	        return true;
	    }
}
