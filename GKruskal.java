import java.util.*;
public class GKruskal
{
	public static int[][] kruskal(int g[][],int n)
	{
        int m[][]=new int[n-1][3],p[]=new int[n];
        for(int i=0;i<n;i++)
        p[i]=i;
        int c=0,cost=0;
        while(c<n-1)
        {
            int min=Integer.MAX_VALUE,a=-1,b=-1;
            for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            if(find(i,p)!=find(j,p) && g[i][j]<min)
            {
                min=g[i][j];
                a=i;b=j;
            }
            union(a,b,p);
            m[c][0]=a;m[c][1]=b;m[c][2]=min;
            cost+=min;
            c++;
        }
        return m;
    }
    public static int find(int i,int p[])
    {
        while(p[i]!=i)
        i=p[i];
        return i;
    }
    public static void union(int i,int j,int p[])
    {
        int a=find(i,p),b=find(j,p);
        p[a]=b;
    }
	public static void main(String arg[])
	{
		InOut io=new InOut(arg[0],arg[1]);//Refer Appendix I
        int n=io.in.nextInt(),g[][]=new int[n][n];
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        if(io.in.hasNextInt())
        g[i][j]=io.in.nextInt();
        else
        {
            g[i][j]=Integer.MAX_VALUE;
            io.in.next();
        } 
        int m[][]=kruskal(g,n);
        io.out.println("Edge \tWeight");
        for(int i=0;i<n-1;i++)
        io.out.println((char)(m[i][0]+65)+"-"+(char)(m[i][1]+65)+" \t "+m[i][2]);
		io.in.close();
		io.out.close();
	}
}