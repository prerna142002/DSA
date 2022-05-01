package DP;
import java.util.*;
import java.io.*;

public class longestCommonSequence {

//	static int[][] dp;
//	static int func(String s1, String s2, int i1,int i2)
//	{
//		if(i1 == s1.length()-1 || i2 == s2.length()-1)
//		{
//			if(s1.charAt(i1) == s2.charAt(i2) ) return 1;
//			return 0;
//		}
//		
//		if(dp[i1][i2] != -1) return dp[i1][i2]; 
//		int a = 0;
//		
//		if(s1.charAt(i1) == s2.charAt(i2))  {
//			a = 1;
//			if( ( (i1<s1.length()-1 && i2<s2.length()-1) && (s1.charAt(i1+1) == s2.charAt(i2+1) ) )){
//				a += func(s1,s2,i1+1,i2+1);
//				return a; 
//			}
////			a = Math.max(a,func(s1,s2,i1,i2+1));
//		}
//		dp[i1][i2] = a;
//		a = Math.max( func(s1,s2,i1,i2+1) , func(s1,s2,i1+1,i2) );
//		
//		return a;
//		
//	}
	
	public static void main(String[] args) throws IOException {
		
		InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        
        String S1 = in.next(), S2 = in.next();
        
        int[][] dp = new int[S2.length()+1][S1.length()+1];
        dp[0][0] = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
		
		for(int i=1;i<=S2.length();i++)
		{
			for(int j=1;j<=S1.length();j++)
			{
				if( S1.charAt(j-1) == S2.charAt(i-1) ) dp[i][j]=dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		String ans = "";

		int val = dp[S2.length()][S1.length()];
		int i = S2.length(), j = S1.length();
		int prev = 0;
		while( val>0 )
		{
			if( S1.charAt(j-1) == S2.charAt(i-1) && (prev!=val) )
			{
				ans = S1.charAt(j-1)+ans;
				prev = val;
				i--;
				j--;
				val-=1;
			}
			else
			{
				if(dp[i][j-1] == val) j -= 1;
				else i -= 1;
			}
		}
		
		System.out.println(ans);
		
		out.close();
		
//		Recurssion and Memoization
//		dp = new int[S1.length()][S2.length()];	
//		for(int i=0;i<S1.length();i++) Arrays.fill(dp[i],-1);
//		System.out.println(func(S1,S2,0,0));

	}
	
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
    }

}
