import java.util.List;
import java.util.Stack;

//Given a nested list of integers, implement an iterator to flatten it.
//
//Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//
//Example 1:
//Given the list [[1,1],2,[1,1]],
//
//By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
//
//Example 2:
//Given the list [1,[4,[6]]],
//
//By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
//

public class FlattenNestedListIterator {
	 Stack<NestedInteger> st;
	    public NestedIterator(List<NestedInteger> nestedList) {
	        st = new Stack<NestedInteger>();
	        
	        for(int i=nestedList.size()-1;i>=0;i--)
	        {
	            st.push(nestedList.get(i));
	        }
	        
	    }

	    @Override
	    public Integer next() {
	        return st.pop().getInteger();
	    }

	    @Override
	    public boolean hasNext() {
	        while(!st.isEmpty())
	        {
	            NestedInteger top = st.peek();
	            if(top.isInteger())
	                return true;
	            List<NestedInteger> list = st.pop().getList();
	            
	            for(int i=list.size()-1;i>=0;i--)
	            {
	                st.push(list.get(i));
	            }
	        }
	        return false;
	    }
}
// to do 
//Nested List Weight Sum
//
//Flatten 2D Vector
//
//Zigzag Iterator
