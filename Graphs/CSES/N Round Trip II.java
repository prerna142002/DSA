package graphs.CSES;

import java.io.*;
import java.util.*;

public class roundTrip2 {
	
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
				public static ArrayList<ArrayList<Integer>> adj;
				public static int[] visited;
				public static int n, start = 1, end=1;
				public static int[] prev; 
				public static boolean dfs(int z)
				{
					visited[z] = 1;
					for(Integer temp : adj.get(z))
					{
						if( visited[temp] == 1 && prev[temp]==z)
						{
							start = temp;
							end = z;
							return true;
						}
						if( prev[temp] == z ) continue;
						prev[temp] = z;
						if(dfs(temp)) return true;
					}
					visited[z] = 2;
					return false;
				}
				
			public static void main(String[] args) throws IOException{
				  OutputStream outputStream = System.out;
			        // InputReader s = new InputReader(inputStream);
			        PrintWriter pw = new PrintWriter(outputStream);
			        //BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
			        Reader s = new Reader();
				n = s.nextInt();
				long m = s.nextLong();
				
				adj = new ArrayList<>();
				visited = new int[n+1];
				for(int i=0;i<=n;i++)
				{
					adj.add(new ArrayList<>());
				}
				
				HashSet<Integer> list = new HashSet<>();
				for(int i=0;i<m;i++)
				{
//					StringTokenizer s = new StringTokenizer(br.readLine());
					int a1 = s.nextInt();
					int a2 = s.nextInt();
					
					adj.get(a1).add(a2);
				}
//				System.out.println(adj);
//				Queue<Integer> queue = new LinkedList<>();
				prev = new int[n+1];
//				
//				queue.add(1);
//				System.out.println(list);
				boolean ans = false;
				StringBuffer str = new StringBuffer();
				for(int p=1;p<=n;p++) {
					if(visited[p] != 0) continue;
//					System.out.println(p+" "+dfs(p));
//					boolean l = dfs(p);
//					System.out.println(l);
					prev[p] = p;
					if(dfs(p))
					{
						str.append(start).append(" ");
						int index = end;
						int len = 2;
						ArrayList<Integer> Alist = new ArrayList<>();
//						System.out.println(start+" "+end);
						while(index != start )
						{
							Alist.add(index);
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
				}
				if(!ans) pw.print("IMPOSSIBLE");
				pw.close();
		 
			}
		 
}
