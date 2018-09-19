import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine().trim());
		for(int c=0;c<t;c++){
			String [] n_q = br.readLine().trim().split(" ");
			int n = Integer.parseInt(n_q[0]);
			int q = Integer.parseInt(n_q[1]);
			long value = 1;
			String [] values = br.readLine().trim().split(" ");
			for(int i=0;i<n;i++){
				long num = Long.parseLong(values[i]);
				if(value <Integer.MAX_VALUE && num>1){
					value = value*num;
				}
			}

			String [] queries = br.readLine().trim().split(" ");
			for(int i=0;i<q;i++){
				long num = Long.parseLong(queries[i]);
				System.out.print(num/value + " ");
			}
			System.out.println();
		}
	}
}
