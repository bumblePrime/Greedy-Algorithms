import java.util.*;
public class GCoin
{
	public static void main(String arg[])
	{
		InOut io=new InOut(arg[0],arg[1]);
		int n=io.in.nextInt(),d[]=new int[n];
		io.out.print("Entered Denominations:");
		for(int i=0;i<n;i++)
		{
			d[i]=io.in.nextInt();
			io.out.print(d[i]+" ");
		}
		io.out.println();
		Arrays.sort(d);
		int a=io.in.nextInt(),c=0;
		io.out.println("Entered Amount:"+a);
		for(int i=n-1;a!=0 && i>-1;i--)
		{
			c+=(a/d[i]);
			a%=d[i];
		}
		io.out.println("Number of Coins Required:"+c);
		//if(a!=0)
		//	io.out.println("Remaining Amount:"+a);
		io.in.close();
		io.out.close();
	}
}