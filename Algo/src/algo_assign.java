import java.io.*;
import java.util.Arrays;
public class algo_assign {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of iterations");
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		double[] x = new double[n+1];
		double[] y = new double[n+1];
		for(int p=0;p<=n;p++)
		{
			x[p] = Math.random();
			y[p] = Math.random();
			double v = Math.sqrt(x[p]*2 + y[p]*2);
			if (v <= 1)
			{
				count = count +1;
			}
		}
		System.out.println(count);
		System.out.println("value of pi/4 is " + count/n);
		graph.add(x[i],y[i]);
		
		//System.out.println(Arrays.toString(x));		
	}
}