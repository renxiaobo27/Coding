package test;

public class Read4 {

	public int read(char[]buf,int n)
	{
		int i = 0;
		char[] buffer = new char[4];
		
		while(i<n)
		{
			int count = read4(buffer);
			int j =0;
			while(j<count&&i<n)
			{
				buf[i++] = buffer[j++];
			}
			if(count!=4)
				break;
		}
		return i;
	}
	
	
	
	
	
	
	
	
	char[]buffer = new char[4];
	int start = 0;
	int end = 0;
	public int readM(char[]buf,int n)
	{
		int i=0;
		while(i<n)
		{
			if(start==end)
			{
				end = read4(buffer);
				start = 0;
			}
			
			while(i<n&&start<end)
			{
				buf[i++] = buffer[start++];
			}
			if(end!=4)
				break;
		}
		return i;
	}
}
