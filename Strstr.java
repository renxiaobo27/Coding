Implement strStr().

Returns the index of the first occurrence of needle in haystack, 
or -1 if needle is not part of haystack.

public class Strstr {

	public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null)
            return -1;
	  int len1 = haystack.length();
     int len2 = needle.length();   
     if(len2>len1)
         return -1;
        
     int diff = len1-len2;
     int j=0;
     for(int i=0;i<=diff;i++)
     {
         for(j=0;j<len2;j++)
         {
             char c1 = haystack.charAt(j+i);
             char c2 = needle.charAt(j);
             if(c1!=c2)
             {
                 break;
             }
         }
         if(j==len2)
             return i;
     }
     return -1;
	}
	
	
	  public int strStr2(String haystack, String needle) {
	        if(haystack==null || needle==null)
	            return -1;
	            
	        int prime = 13;
	        long tcode = 0;
	        long hashcode = 0;
	        
	       
	        int len1 = haystack.length();
	        int len2 = needle.length();
	        
	        if(len2>len1)
	            return -1;
	            
	       for(int i=0;i<needle.length();i++)
	       {
	           tcode = prime*tcode + needle.charAt(i);
	           hashcode = prime*hashcode + haystack.charAt(i);
	       }
	       if(tcode==hashcode)
	        return 0;
	        
	        for(int i=1;i<=len1-len2;i++)
	        {
	            hashcode = hashcode - haystack.charAt(i-1)*(long)Math.pow(prime,len2-1);
	            hashcode = hashcode*prime + haystack.charAt(i+len2-1);
	            
	            if(hashcode==tcode)
	            {
	                return i;
	            }
	        }
	       
	       return -1;
	    }
}
