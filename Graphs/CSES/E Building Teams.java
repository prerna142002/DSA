import java.io.*;
import java.util.*;
 
public class main{
	
	public static boolean[] visited;
	public static int[] team;
	public static ArrayList<ArrayList<Integer>> adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		adj = new ArrayList<>();
		visited = new boolean[n+1];
		for(int i=0;i<=n;i++)
		{
			adj.add(new ArrayList<>());
			visited[i] = false;
		}
		
		for(int i=0;i<m;i++)
		{
			StringTokenizer s = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(s.nextToken());
			int a2 = Integer.parseInt(s.nextToken());
			
			adj.get(a1).add(a2);
			adj.get(a2).add(a1);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		team = new int[n+1];
		boolean ans = false;
		for(int p=1;p<=n;p++)
		{
			if( visited[p] ) continue;
			queue.add(p);
			team[p] = 1;
			visited[p] = true;
			while(!queue.isEmpty())
			{
				int z = queue.peek();
				queue.poll();
				ArrayList<Integer> temp = adj.get(z);
				for(int i=0;i<temp.size();i++)
				{
					if( team[temp.get(i)] == team[z] ) 
					{
						pw.println("IMPOSSIBLE");
						ans = true;
						break;
					}
					if( visited[temp.get(i)] ) continue;
					team[temp.get(i)] = (team[z]) == 1? 2:1;
					queue.add(temp.get(i));
					visited[temp.get(i)] = true;
				}
				if(ans) break;
			}
			if(ans) break;
		}
		if(!ans ) {
			StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= n; i++) {
                sb.append(team[i]).append(" ");
            }
            pw.println(sb);
        }
        pw.close();
 
	}
 
}
