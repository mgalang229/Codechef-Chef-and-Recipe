import java.io.*;
import java.util.*;

public class Main {
	static final Reader in = new Reader();
	static final PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int t=in.nextInt();
		for(int i=1; i<=t; ++i)
			new Solver();
		out.close();
	}
	
	static class Solver {
		Solver() {
			int n=in.nextInt();
			int a[] = new int[n+1];
			for(int i=0; i<n; ++i)
				a[i]=in.nextInt();
			Map<Integer, Integer> mp1 = new HashMap<Integer, Integer>();
			Map<Integer, Integer> mp2 = new HashMap<Integer, Integer>();
			int cnt=1;
			a[n]=-1;
			for(int i=0; i<n; ++i) {
				if(a[i]==a[i+1])
					cnt++;
				else {
					mp1.put(a[i], mp1.getOrDefault(a[i], 0)+1);
					mp2.put(cnt, mp2.getOrDefault(cnt, 0)+1);
					cnt=1;
				}
			}
			boolean ok=true;
			for(Map.Entry<Integer, Integer> entry : mp1.entrySet())
				if(entry.getValue()!=1) {
					ok=false;
					break;
				}
			for(Map.Entry<Integer, Integer> entry : mp2.entrySet())
				if(entry.getValue()!=1) {
					ok=false;
					break;
				}
			out.println(ok?"YES":"NO");
		}
	}
	
	static class Reader {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String next() {
			while(st==null||!st.hasMoreTokens()) {
				try {
					st=new StringTokenizer(in.readLine());
				} catch(Exception e) {}
			}	
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
