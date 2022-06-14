import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class main {
 
	public static ArrayList<ArrayList<Integer>> adj;
	public static boolean[] visited;
	public static int n, start = 1, end=1;
	public static int[] prev; 
	public static boolean dfs( int z)
	{
		for(Integer i: adj.get(z))
		{
			if( visited[i] && (prev[z]!=i) )
			{
				start = i;
				end = z;
				return true;
			}
			if(visited[i]) continue; 
			
			prev[i] = z;
			visited[i] = true;
			if(dfs(i)) return true;
		}
		return false;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		adj = new ArrayList<>();
		visited = new boolean[n+1];
		for(int i=0;i<=n;i++)
		{
			adj.add(new ArrayList<>());
			visited[i] = false;
		}
		
		HashSet<Integer> list = new HashSet<>();
		for(int i=0;i<m;i++)
		{
			StringTokenizer s = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(s.nextToken());
			int a2 = Integer.parseInt(s.nextToken());
			
			adj.get(a1).add(a2);
			adj.get(a2).add(a1);
			list.add(a1);
			list.add(a2);
		}
		
//		Queue<Integer> queue = new LinkedList<>();
		prev = new int[n+1];
//		
//		queue.add(1);
//		System.out.println(list);
		boolean ans = false;
		for(Integer pp: list   ) {
			int p = pp;
//			System.out.println(p+" ");
			if( visited[p] ) continue;
			visited[p] = true;
			
			prev[p] = -1;
//			System.out.println("aslkh");
			
		if( dfs(p) )
			{
			StringBuffer str = new StringBuffer();
			str.append(start).append(" ");
			int index = end;
			int len = 2;
			ArrayList<Integer> Alist = new ArrayList<>();
			while( index!=-1 && index != start )
			{
				Alist.add(index);
//				str.append(" ").append(index);
				index = prev[index];
				len++;
			}
			ans = true;
			
			for(int i=Alist.size()-1;i>=0;i--)
			{
				str.append(Alist.get(i)).append(" ");
			}
			str.append(start);
			
			pw.println(len+"\n"+str);
			break;
			}
		if(ans) break;
		}
		if(!ans) pw.println("IMPOSSIBLE");	
		pw.close();
		
//		System.out.println("dfs "+dfs(1));
//
//		System.out.println(start+" "+end);
//		for(int i: prev) System.out.println(i);
 
	}
 
}
