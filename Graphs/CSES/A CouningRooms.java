import java.io.*;
import java.util.*;
 
public class main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] dirx = {1,-1,0,0};
		int[] diry = {0,0,-1,1};
 
		ArrayList<Integer> sources = new ArrayList<>();
		boolean[][] visited = new boolean[n][m];
		char[][] ch = new char[n][m];
		
		boolean[][] wall = new boolean[n][m];
		for(int i=0;i<n;i++)
		{
			char[] c = br.readLine().toCharArray();
			for(int j=0;j<m;j++) 
			{
				ch[i][j] = c[j];	
				visited[i][j] = false;
				if( c[j] == '#' ) wall[i][j] = true;
				else wall[i][j] = false;
			}
		}
		
		Stack<Integer> stackX = new Stack<>();
		Stack<Integer> stackY = new Stack<>();
		
		int ans = 0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if( visited[i][j]) continue;
				if( wall[i][j] ) continue;
				
				stackX.push(i);
				stackY.push(j);
				while(!stackX.isEmpty())
				{
					int xx = stackX.pop();
					int yy = stackY.pop();
					visited[xx][yy] = true;
					for(int c=0;c<4;c++)
					{
						int x_ = xx+dirx[c], y_ = yy+diry[c];
						if( x_ <0 || x_>=n || y_ < 0 || y_>=m	 ) continue;
						if( visited[x_][y_] ) continue;
						if( wall[x_][y_] ) continue;
						
						stackX.push(x_);
						stackY.push(y_);
					}
				}
				ans+=1;
				
			}
		}
		System.out.println(ans);
		
	}
 
}
 
