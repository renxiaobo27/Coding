import java.util.Stack;

//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Some examples:
//  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
//  
public class Basic_EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0)
            return 0;
        Stack<Integer> st = new Stack<Integer>();
        int v1 = 0;
        int v2 = 0;
        
        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("+"))
            {
                st.push(st.pop()+st.pop());
            }
            else if(tokens[i].equals("-"))
            {
                 v2 = st.pop();
                 v1 = st.pop();
                st.push(v1-v2);
            }
            else if(tokens[i].equals("*"))
            {
                 st.push(st.pop()*st.pop());
            }
            else if(tokens[i].equals("/"))
            {
                v2 = st.pop();
                v1 = st.pop();
                st.push(v1/v2);
            }
            else
            {
                int val = Integer.parseInt(tokens[i]);
                st.push(val);
            }
        }
        return st.pop();
    }
}
