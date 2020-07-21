import java.util.*;
public class GDijkstra
{

	public static int[] dijkstra(int g[][],int n,int src)
	{
        int d[]=new int[n];
        Boolean s[]=new Boolean[n];
        Arrays.fill(d,Integer.MAX_VALUE);
        Arrays.fill(s,false);
        d[src]=0;
        for(int i=0;i<n-1;i++)
        {
            int a=minDis(d,s);
            s[a]=true;
            for(int j=0;j<n;j++)
            if(!s[j] && g[a][j]!=0 && d[a]!=Integer.MAX_VALUE && (d[a]+g[a][j])<d[j])
            d[j]=d[a]+g[a][j];
        }
        return d;
    }
    public static int minDis(int d[], Boolean s[]) 
    { 
        int min=Integer.MAX_VALUE,mi=-1; 
        for (int i=0;i<d.length;i++) 
        if(s[i]==false && d[i]<=min) 
        { 
            min=d[i]; 
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
        int src=io.in.nextInt(); 
        int d[]=dijkstra(g,n,src);
        io.out.println("Vertex \tDistance");
        for(int i=0;i<n;i++)
        io.out.println(i+" \t\t "+d[i]);
		io.in.close();
		io.out.close();
	}
}