import java.util.*;
public class Main {

	public static ArrayList<ArrayList<Integer>> mat;
//	public static ArrayList<ArrayList<Integer>> visited;
	public static long n,visited[];
//	public static int
	public static long dfs(int i)
	{
		if( mat.get(i).size() == 0 ) return 0;

		if( visited[i] != -1 ) return visited[i]; 
		
		long ans = 0;
		for(Integer t: mat.get(i))
		{
			ans = Math.max( ans , 1+dfs(t));
		}
		visited[i] = ans;
		return ans;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		mat= new ArrayList<>();
		visited = new long[100001];	
		
		for(int i=0;i<=n;i++)
		{
			mat.add( new ArrayList<>() );
			visited[i] = -1;
//			visited.add(new ArrayList<>());
		}
		
		for(int i=0;i<m;i++)
		{
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			
			ArrayList<Integer> temp = mat.get(a1);
			temp.add(a2);
//			mat[a1][a2] = 1;
		}
		long max = 0;

		for(int i=1;i<=n;i++) max = Math.max(max, dfs(i));
		
		System.out.println(max);
		
	}

}
