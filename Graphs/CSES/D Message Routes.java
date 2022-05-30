import java.io.*;
import java.util.*;
 
public class main {	
	
	public static ArrayList<ArrayList<Integer>> adj;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList<>();
		
		for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
		
		for(int i=0;i<m;i++)
		{
			StringTokenizer s = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(s.nextToken());
			int a2 = Integer.parseInt(s.nextToken());
			
			ArrayList<Integer> l1 = adj.get(a1);
			ArrayList<Integer> l2 = adj.get(a2);
			l1.add(a2);
			l2.add(a1);
			adj.set(a1,l1);
			adj.set(a2,l2);
		}
		
		// System.out.println(adj);
		
		boolean[] selected = new boolean[n+1];
		long[] dist = new long[n+1];
		int[] prev = new int[n+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		if( adj.get(1).size() == 0)
		{
			pw.println("IMPOSSIBLE");				
		}
		else
		{
			Queue<Integer> queue = new LinkedList<>();
			queue.add(1);
			dist[1] = 1;
			selected[1] = true;
			while(!queue.isEmpty())
			{
				int val = queue.remove();
				ArrayList<Integer> temp = adj.get(val);
				boolean bb = false;
				for(int i=0;i<temp.size();i++)
				{
					int s = temp.get(i);
					if(selected[s]) continue;
					selected[s] = true;
					dist[s] = dist[val]+1;
					prev[s] = val;
					queue.add(s);
					if(s == n) bb=true;
				}
				if(bb) break;
			}
			
			int index = n;
			if( dist[index] == Long.MAX_VALUE ) pw.println("IMPOSSIBLE");
			else 
			{
				ArrayList<Integer> path = new ArrayList<>();
				path.add(index);
				while(index!=1)
				{
					path.add(prev[index]);
					index = prev[index];
				}
				System.out.println(dist[n]);
				for(int i=path.size()-1;i>=0;i--)
				{
					pw.print(path.get(i)+" ");
				}		
			}
		}
		pw.close();	
	}
}
