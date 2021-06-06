/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc= new Scanner(System.in);
		if(sc.hasNext())
		{
		    int t = sc.nextInt();
		    while(t-->0)
		    {
		        int n = sc.nextInt();
		        int c = sc.nextInt();
		        int[] a = new int[n];
		        int sum=0;
		        for(int p=0;p<n;p++)
		        {
		            a[p]=sc.nextInt();
		            sum += a[p];
		        }
		        if(sum<=c) System.out.println("Yes");
		        else System.out.println("No");
		        
		    }
		}
	}
}
