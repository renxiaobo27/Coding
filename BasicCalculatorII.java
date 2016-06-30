import java.util.Collections;
import java.util.LinkedList;

//Implement a basic calculator to evaluate a simple expression string.
//
//The expression string contains only non-negative integers, +, -, *, / operators and 
//empty spaces . The integer division should truncate toward zero.
//
//You may assume that the given expression is always valid.
//
//Some examples:
//"3+2*2" = 7
//" 3/2 " = 1
//" 3+5 / 2 " = 5

//先处理*/ 然后再处理+-
public class BasicCalculatorII {

	 public int calculate(String s) {
	        if(s==null || s.length()==0)
	            return 0;
	        
	        LinkedList<Integer> list = new LinkedList<Integer>();
	        for(int i=0;i<s.length();i++)
	        {
	            char c = s.charAt(i);
	            if(Character.isDigit(c))
	            {
	                int cur = c-'0';
	                while(i+1<s.length()&&Character.isDigit(s.charAt(i+1)))
	                {
	                    cur = cur*10 + s.charAt(i+1)-'0';
	                    i++;
	                }
	                
	                if(!list.isEmpty() && (list.peek()==2||list.peek()==3))
	                {
	                    int op = list.pop();
	                    int val = list.pop();
	                    if(op==2)
	                    {
	                        list.push(val*cur);
	                    }
	                    else
	                        list.push(val/cur);
	                }
	                else
	                {
	                    list.push(cur);
	                }
	            }
	            
	            else if(c==' ') continue;
	            else
	            {
	                switch(c)
	                {
	                    case '+':list.push(0);break;
	                    case '-':list.push(1);break;
	                    case '*':list.push(2);break;
	                    case '/':list.push(3);break;
	                }
	                
	            }
	            
	        }
	        
	        
	        if(list.isEmpty()) return 0;
	        Collections.reverse(list);
	        int res = list.pop();
	        while(!list.isEmpty())
	        {
	            int op = list.poll();
	            int v = list.poll();
	            if(op==0)
	                res = res + v;
	            else
	                res = res - v;
	        }
	        return res;
	    }
}
