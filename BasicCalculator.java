import java.util.Stack;

//Implement a basic calculator to evaluate a simple expression string.
//
//The expression string may contain open ( and closing parentheses ), 
//the plus + or minus sign -, non-negative integers and empty spaces .
//
//You may assume that the given expression is always valid.
//
//Some examples:
//"1 + 1" = 2
//" 2-1 + 2 " = 3
//"(1+(4+5+2)-3)+(6+8)" = 23
//

public class BasicCalculator {

	 public int calculate(String s) {
		 if(s==null || s.length()==0)
			 	return 0;
		 int result = 0;
		 int number = 0;
		 int sign = 1;
		 Stack<Integer> st = new Stack<Integer>();
		 for(int i=0;i<s.length();i++)
		 {
			 char c = s.charAt(i);
			 if(Character.isDigit(c))
			 {
				 number = number *10 + (int)(c-'0');
			 }
			 else if(c=='-')
			 {
				 result += sign*number;
				 sign = -1;
				 number = 0;
			 }
			 else if(c=='+')
			 {
				 result += sign*number;
				 sign = 1;
				 number = 0;
			 }
			 else if(c=='(')
			 {
				 st.push(result);
				 st.push(sign);
				 result = 0;
				 sign = 1;
			 }
			 else if(c==')')
			 {
				 result += sign *number;
				 result *= st.pop();
				 result += st.pop();
				 number = 0;
			 }
		 }
		 
		 if(number!=0) result += sign*number;
		 return result;
	 }
}
