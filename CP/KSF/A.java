package Tree.Self;
import java.util.*;

public class Main {
	public static int ans = 0;
	static class Cloth {
		
	    String c;
	    int d, u;
	 
	    // Parameterized constructor
	    public Cloth(String c, int d, int u)
	    {
	        this.c = c;
	        this.d = d;
	        this.u = u;
	    }
	 
	    // Getter setter methods
	    public String getColor() { return c; }
	    public int getD() { return d; }
	    public int getU() { return u; }
	
	}
	    // Class 2
	    // Helper class implementing Comparator interface
	    static class AdaComparare
	        implements Comparator<Cloth> {
	 
	        // Method 1
	        // To compare customers
	        @Override
	        public int compare(Cloth customer1,
	        		Cloth customer2)
	        {
	 
	            // Comparing customers
	            int ColorCompare = customer1.getColor().compareTo(
	                customer2.getColor());
	 
	            int a = customer1.getU();
	            int b = customer2.getU();
	            int UniqueCompare  = 0;
	            if(a>b) UniqueCompare = 1;
	            else if(a<b) UniqueCompare = -1;
	            // 2nd level comparison
	            return (ColorCompare == 0) ? UniqueCompare
	                                      : ColorCompare;
	        }
	    
	    }
	    static class CharlesComparare
        implements Comparator<Cloth> {
 
        // Method 1
        // To compare customers
        @Override
        public int compare(Cloth customer1,
        		Cloth customer2)
        {
 
            // Comparing customers
        	int a = customer1.getD();
            int b = customer2.getD();
            int DuraCompare  = 0;
            if(a>b) DuraCompare = 1;
            else if(a<b) DuraCompare = -1;
 
            a = customer1.getU();
            b = customer2.getU();
            int UniqueCompare  = 0;
            if(a>b) UniqueCompare = 1;
            else if(a<b) UniqueCompare = -1;
            
            int aa = (DuraCompare == 0) ? UniqueCompare
                    : DuraCompare;
//            if( compare1(customer1,customer2) == aa ) ans+=2;
            return aa;
        }
    
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int z = 1;
		while(t-->0) {
			ans=0;
			int n = sc.nextInt();
			List<Cloth> c = new ArrayList<>();
			for(int i=0;i<n;i++) {
				String str = sc.next();
				int i1 = sc.nextInt();
				int i2 = sc.nextInt();
				Cloth p = new Cloth(str,i1,i2);
				c.add(p);
			}
			
			Collections.sort(c,
                    new AdaComparare());
			ArrayList<Cloth> l = new ArrayList<>();
			for(int i=0;i<c.size();i++) {
				l.add(c.get(i));
			}
			Collections.sort(c,
                    new CharlesComparare());
			for(int i=0;i<c.size();i++) {
				if(l.get(i) == c.get(i)) ans++;
			}
			System.out.println("Case #"+z+": "+ans);
			z+=1;
//			
		}
	}

}
