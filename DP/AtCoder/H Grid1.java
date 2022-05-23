import java.util.*;
public class Main{
	static int[][] dp;
	static int steps(String[][] mat, int i, int j)
	{
		if(i >= mat.length || j >= mat[0].length) return 0;
		if(dp[i][j]!=-1) return dp[i][j];
		if(mat[i][j].equals("#")) return 0;
		
		if(i == mat.length-1 && j == mat[i].length-1) return 1;
		
//        if (!mat[i][j].equals("#") && !mat[i][j].equals(".")) {
//            return Integer.parseInt(mat[i][j]);
//        }
		
		dp[i][j]= (int) (steps(mat,i+1,j) + steps(mat,i,j+1))%1000000007;
		return dp[i][j];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		String[][] mat = new String[a][b];
		dp = new int[a+1][b+1];
		for(int i=0;i<a;i++)
		{
			String z = sc.next();
			for(int j=0;j<z.length();j++)
				{
					mat[i][j] = ""+z.charAt(j);
					dp[i][j] = -1;
				}
		}
		dp[a][b] = -1;
		System.out.println(steps(mat,0,0));
		
		

	}

}
