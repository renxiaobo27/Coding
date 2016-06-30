//Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
//
//Example:
//Given num = 16, return true. Given num = 5, return false.
//
//Follow up: Could you solve it without loops/recursion?
//		
public class PowerofFour {

	public boolean isPowerOfFour(int num) {
		if(num<=0) return false;
		//method 1
		
		while(num%4==0)
		{
			num = num / 4;
		}
		return num==1;
		
		//method 2
		
		//return ((num&(num-1))==0)&& (num&0x55555555)==num);
	}
}
