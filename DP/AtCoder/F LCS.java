import java.util.*;
import java.io.*;

public class Main {
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
