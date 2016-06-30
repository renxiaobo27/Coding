
public class ValidNumber {
	public boolean isNumber(String s) {
        if(s==null || s.length()==0 )
            return false;
        s = s.trim();// 先trim
        if(s.length()>0 && (s.equals(".") || s.charAt(s.length()-1)=='e'))//以e结尾
            return false;
        
        String []strs = s.split("e");
        if(strs.length==0 ||strs.length>2) return false;
        
        boolean re = false;
        
        re = help(strs[0],false);
        
        if(strs.length==1)
            return re;
        re = re & help(strs[1],true);
        return re;
        
    }
    
    public boolean help(String s,boolean hasDot)
    {
        
        if(s.length()>0 && (s.charAt(0)=='+'||s.charAt(0)=='-'))//4a+ // -.
            s = s.substring(1);
        if(s.equals(".")) return false;
        if(s.length()==0) return false;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            
            if(c=='.')
            {
                if(hasDot)
                    return false;
                hasDot = true;
            }
            
            else if(c<'0' || c>'9')
                return false;
            
        }
        return true;
    }
}
