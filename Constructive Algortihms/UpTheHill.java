  import java.util.*;
public class main {
	
    public static void main (String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int t = 1;
    	while(t-->0)
    	{
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int ia = 1, ib = a+b+1;
    		StringBuffer str = new StringBuffer();
    		while(a-->0)
    		{
    			str.append(ia).append(" ");
    			ia+=1;
    		}
    		str.append(ib).append(" ");
    		StringBuffer s1 = new StringBuffer();
//    		ia = a==0?ib:ia;
    		ia = ib-1;
    		while(b-->0)
    		{
    			if(b==0) s1.append(ia);
    			else s1.append(ia).append(" ");
    			ia-=1;
    		}
    		
//    		s1.reverse();
    		str.append(s1);
    		System.out.println(str);
    	}
    	
    }
}
