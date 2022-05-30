import java.io.*;
import java.util.*;
 
class edge{
	int start = 0;
	long val = 0;
	edge(int start, long val)
	{
		this.start = start;
		this.val = val;
	}
	int getStart()
	{
		return start;
	}
	long getEdge()
	{
		return val;
	}
	void setEdge(int e)
	{
		if(val > e) val = e;
	}
}
 
class pair implements Comparable<pair> {
    int val;
    long wsf;
    pair(int val, long wsf) {
        this.val = val;
        this.wsf = wsf;
    }
 
    @Override
    public int compareTo(pair pp) {
        return (int)(this.wsf - pp.wsf);
    }
}
 
public class main {
	
	
	
	public static ArrayList<ArrayList<edge>> adj;
	public static boolean[] visited;
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
 
		adj = new ArrayList<>();
		visited = new boolean[n+1];
		long[] dist = new long[n+1];
		
		ArrayList<HashSet<Integer>> set = new ArrayList<>();
		
		for(int i=0;i<=n;i++)
		{
			ArrayList<edge> l = new ArrayList<>();
			adj.add(l);	
			set.add(new HashSet<>());
			visited[i]=false;
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<m;i++)
		{
			StringTokenizer s = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(s.nextToken());
			int a2 = Integer.parseInt(s.nextToken());
			long a3 = Integer.parseInt(s.nextToken());
			ArrayList<edge> l1 = adj.get(a1);
			edge e1 = new edge(a2,a3);
			
			l1.add(e1);
		}
		
		
//		Dikstra's Algorithm
		dist[1] = 0;				
		PriorityQueue<pair> queue = new PriorityQueue<>();
		queue.add(new pair(1,0));
		
		while(!queue.isEmpty())
		{
			pair a = queue.remove();	
			if(visited[a.val]) continue;
			visited[a.val] = true;
			dist[a.val] = a.wsf;
			for(edge e : adj.get(a.val)) {
                queue.add(new pair(e.start, a.wsf + e.val));
            }
		}
		
		for(int i=1;i<=n;i++) pw.print(dist[i]+" ");
		
		
		pw.close();
	}
 
}
