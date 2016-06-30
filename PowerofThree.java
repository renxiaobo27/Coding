
public class PowerofThree {

	 public boolean isPowerOfThree(int n) {
	        if (n <= 0) {
	            return false;
	        } else {
	            return n > 0 && 1162261467 % n == 0; //1162261467=3^19
	        }
	    }
}
