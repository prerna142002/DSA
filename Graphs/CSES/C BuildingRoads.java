import java.io.*;
import java.util.*;
 
public class main {
	
	public static boolean[] visited; 
	public static ArrayList<ArrayList<Integer>> adj;
	static void dfs(int p)
	{
		if(visited[p] ) return; 
		visited[p] = true;
		for(int ip: adj.get(p))
		{
			if(visited[ip]) continue;
			dfs(ip);
		}
	}
 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList<>();
		for(int i=0;i<=n;i++)
		{
			adj.add(new ArrayList<>());
		}
		
		for(int j=0;j<m;j++)
		{
			StringTokenizer s = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(s.nextToken());
			int a2 = Integer.parseInt(s.nextToken());
			
			ArrayList<Integer> t1 = adj.get(a1);
			ArrayList<Integer> t2 = adj.get(a2);
			
			t1.add(a2);
			t2.add(a1);
			
			adj.set(a1, t1);
			adj.set(a2, t2);
		}
		visited = new boolean[n+1];
		
		ArrayList<Integer> start = new ArrayList<>();
 
		for(int i=1;i<=n;i++)
		{
			if(visited[i]) continue;
			start.add(i);
			dfs(i);
		}
		
		if(start.size() > 1) 
		{
			System.out.println(start.size()-1);
			for (int i=1;i<start.size();i++) {
				pw.println(start.get(i-1)+ " "+start.get(i));
	        }
		}
		else pw.println(0);
		pw.close();	
	}
 
}
