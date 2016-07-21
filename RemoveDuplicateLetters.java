//Given a string which contains only lowercase letters, 
//remove duplicate letters so that every letter appear 
//once and only once. You must make sure your result is 
//the smallest in lexicographical order among all possible results.
//
//Example:
//Given "bcabc"
//Return "abc"
//
//Given "cbacdcbc"
//Return "acdb"


//读字符的过程中，把字符存到stack里，
//当发现stack之前存的字符中比当前字符大而且频率还大于0就可以把那个字符pop出去。
//类似这种题目都可以用stack解决。
//基本思想就是在一定的限制条件下pop出比当前选择差的元素。

public class RemoveDuplicateLetters {

	public String removeDuplicateLetters(String s) {
        if(s==null || s.length()==0)
            return "";
        int[]fre = new int[256];
        boolean []visited = new boolean [256];
        
        for(int i=0;i<s.length();i++)
        {
            fre[s.charAt(i)]++;
        }
        
        Stack<Character> st = new Stack<Character>();
        
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            fre[c]--;
            if(visited[c]) continue;
            
            while(!st.isEmpty() && st.peek()>c && fre[st.peek()]>0)
            {
                visited[st.pop()] = false;
            }
            st.push(c);
            visited[c] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }
}
