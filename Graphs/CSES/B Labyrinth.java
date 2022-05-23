import java.util.*;
import java.io.*;
public class main {
 
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		char[][] ch = new char[n][m];
		int[][] dec = new int[n][m];
		int[] dirx = {1,-1,0,0};
		int[] diry = {0,0,1,-1};
		String[] dirp = {"D","U","R","L"};
		Queue<Integer> queuex = new LinkedList<>();
		Queue<Integer> queuey = new LinkedList<>();
		
		boolean[][] visited = new boolean[n][m];
		boolean[][] wall = new boolean[n][m];
		int endX = 0, endY = 0, startX = 0, startY = 0;
		
		int[][] prevDir = new int[n][m];
		
//		Adding the elements in the GRID.
		for(int i=0;i<n;i++)
		{
			char[] c = br.readLine().toCharArray();
			for(int j=0;j<m;j++) 
			{
				ch[i][j] = c[j];
				if( ch[i][j] == 'A' )
				{
					startX = i;
					startY = j;
					queuex.add(i);
					queuey.add(j);
				}
				else if( ch[i][j] == 'B' )
				{
					endX = i;
					endY = j;
				}
				else
					{
						if( ch[i][j] == '#' ) wall[i][j] = true;
						else wall[i][j] = false;
					}
				dec[i][j] = Integer.MAX_VALUE;
				prevDir[i][j] = -1;
				visited[i][j] = false;
			}
		}
		dec[startX][startY] = 0;
//		System.out.println(queuex.peek()+" "+queuey.peek());
		while(!queuex.isEmpty())
		{
			int x = queuex.remove();
			int y = queuey.remove();
			if(visited[x][y]) continue;
			visited[x][y] = true;
			
			for(int i=0;i<4;i++)
			{
				int xx = x+dirx[i], yy = y+diry[i];
				if( xx<0 || yy<0 || xx>=ch.length || yy>=ch[0].length ) continue;
				
				if(wall[xx][yy]) continue;
				if(visited[xx][yy]) continue;
				
				queuex.add(xx);
				queuey.add(yy);
				prevDir[xx][yy] = i;
			}			
		}
 
		int X = endX, Y = endY, endV = dec[X][Y];
//		
		if(visited[endX][endY])
		{
//			System.out.println("YES \n"+endV);
			ArrayList<Integer> move = new ArrayList<>();
			while(X != startX || Y!=startY)
			{
				int ii = prevDir[X][Y];
				X = X-dirx[ii];
				Y = Y-diry[ii];
				move.add(ii);
			}
			pw.println("YES");
			pw.println(move.size());
			for(int i=move.size()-1;i>=0;i--) pw.print(dirp[move.get(i)]);
		}
		else pw.println("NO");
		
		pw.close();
		
		
	}
 
}
