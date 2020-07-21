import java.util.*;
public class GKnap
{
    public static double sack(List<Integer> w,List<Integer> v,int c)
    {
        int n=w.size(),u=c;
        List<Double> p=new ArrayList<Double>(n);
        for(int i=0;i<n;i++)
        p.add((double)(v.get(i))/(w.get(i)));
        for(int i=0;i<n-1;i++)
        for(int j=0;j<(n-i-1);j++)
        if(p.get(j)<p.get(j+1))
        {
            Collections.swap(p,j,j+1);
            Collections.swap(w,j,j+1);
            Collections.swap(v,j,j+1);      
        }
        double r=0.0d;
        for(int i=0;i<n;i++)
        {
            if(w.get(i)>=u)
            {
                double f= ((double)u/(double)w.get(i)); 
                r+=(v.get(i)*f);
                u=(int)(u-(w.get(i)*f));
                break; 
            }
            else
            {
                r+=v.get(i);
                u-=w.get(i);
            }
        }    
        return r;
    }
	public static void main(String arg[])
	{
        InOut io=new InOut(arg[0],arg[1]);
        List<Integer> v=new ArrayList<Integer>(2),w=new ArrayList<Integer>(2);
        while(io.in.hasNextInt())
        v.add(io.in.nextInt());
        int c=v.get(v.size()-1);
        v.remove(v.size()-1);
        w=v.subList(v.size()/2,v.size());
        v=v.subList(0,v.size()/2);
        io.out.println("Given Weights:"+Arrays.toString(w.toArray()));
        io.out.println("Given Values :"+Arrays.toString(v.toArray()));
		io.out.println("Capacity Of Knapsack:"+c+"\nMax Value:"+sack(w,v,c));
		io.in.close();io.out.close();
	}
}