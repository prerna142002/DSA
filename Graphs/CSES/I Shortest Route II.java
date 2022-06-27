import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
public class main {
	
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
 
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
 
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
 
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
 
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
 
            if (neg) 
                return -ret; 
            return ret; 
        } 
 
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
 
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
 
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
 
            if (neg) 
                return -ret; 
            return ret; 
        } 
 
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
 
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
 
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
	
	public static void main(String[] args) throws IOException {
		  OutputStream outputStream = System.out;
	        // InputReader s = new InputReader(inputStream);
	        PrintWriter pw = new PrintWriter(outputStream);
	        //BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	        Reader s = new Reader();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter pw = new PrintWriter(System.out);
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = s.nextInt();
		int m = s.nextInt();
		int q = s.nextInt();
		
		long[][] mat = new long[n+1][n+1];
		
//		Arrays.stream(mat).forEach(a -> Arrays.fill(a, Long.MAX_VALUE));
		
		for(int i=1;i<=n;i++)
		{
			Arrays.fill(mat[i], Long.MAX_VALUE);
			mat[i][i] = 0;
		}
		
		for(int i=0;i<m;i++)
		{
//			StringTokenizer s = new StringTokenizer(br.readLine());
			int a1 = s.nextInt();
			int a2 = s.nextInt();
			long a3 = s.nextLong();
			
			mat[a1][a2] = Math.min(mat[a1][a2],a3);
			mat[a2][a1] = Math.min(mat[a1][a2],a3);
		}
		
		int ite = n;
//		if( n >= 400 ) {
//			ite = 399;
//		}			
		
//		int dup = 0;
		for(int i=1;i<=ite;++i)
		{
//			boolean change = false;
			for(int x=1;x<=n;++x)
			{
//				if( x == i) continue;
				for(int y=1;y<=n;++y)
				{
//					if(x == y) continue;
					if( mat[x][i] == Long.MAX_VALUE ) continue;
					if( mat[i][y] == Long.MAX_VALUE ) continue;
//					if( mat[x][i] >= mat[x][y] ) continue;
//					if( mat[i][y] >= mat[x][y] ) continue;
					mat[x][y] = Math.min( mat[x][y],mat[x][i]+mat[i][y] );
//					long p = (mat[x][i] + mat[i][y]);
//					if( mat[x][y] > p )
//					{
//						mat[x][y] = p;
//						change = true;
//					}
				}
			}
//			if(!change) dup++;
//			else dup = 0; 
//			if( dup>5 ) break;
		}	
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<q;i++)
		{
//			StringTokenizer s = new StringTokenizer(br.readLine());
			int a1 = s.nextInt();
			int a2 =s.nextInt();
			if( mat[a1][a2] == Long.MAX_VALUE ) sb.append("-1\n");
			else sb.append(mat[a1][a2]).append("\n");
		}
		pw.println(sb);
		pw.close();
	}
 
}
