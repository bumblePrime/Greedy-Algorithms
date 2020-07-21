import java.util.*;
public class GPrims
{

	public static int[] prims(int g[][],int n)
	{
        int p[]=new int[n],k[]=new int[n];
        Boolean s[]=new Boolean[n];
        Arrays.fill(k,Integer.MAX_VALUE);
        Arrays.fill(s,false);
        k[0]=0;p[0]=0;
        for(int i=0;i<n-1;i++)
        {
            int a=minKey(k,s);
            s[a]=true;
            for(int j=0;j<n;j++)
            if(g[i][j]!=0 && s[j]==false && g[i][j]<k[j])
            {
                p[j]=a;k[j]=g[i][j];
            }
        }
        return p;
    }
    public static int minKey(int k[], Boolean s[]) 
    { 
        int min=Integer.MAX_VALUE,mi=-1; 
        for (int i=0;i<k.length;i++) 
        if(s[i]==false && k[i]<min) 
        { 
            min=k[i]; 
            mi=i; 
        } 
        return mi; 
    } 
	public static void main(String arg[])
	{
		InOut io=new InOut(arg[0],arg[1]);//Refer Appendix I
        int n=io.in.nextInt(),g[][]=new int[n][n];
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        if(io.in.hasNextInt())
        g[i][j]=io.in.nextInt();  
        int p[]=prims(g,n);
        io.out.println("Edge \tWeight");
        for(int i=1;i<n;i++)
        io.out.println(p[i]+"-"+i+" \t "+g[i][p[i]]);
		io.in.close();
		io.out.close();
	}
}