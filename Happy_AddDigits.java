//Given a non-negative integer num, repeatedly add all its 
//digits until the result has only one digit.
//
//For example:
//
//Given num = 38, the process is like: 3 + 8 = 11, 
//1 + 1 = 2. Since 2 has only one digit, return it.
		
public class Happy_AddDigits {

	 public int addDigits(int num) {
	        if(num<=0) // think about case 0
	            return 0;
	        while(num/10>0)//>10 think about case 1
	        {
	            int re = 0;
	            while(num>0)
	            {
	                re +=num%10;
	                num /=10;
	            }
	            num = re;
	        }
	        return num;
	    }
}
