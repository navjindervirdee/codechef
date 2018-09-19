import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.math.*;
public class Main{
	private static DecimalFormat df = new DecimalFormat(".#########");
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for(int p=0;p<t;p++){
			int n = Integer.parseInt(br.readLine().trim());
			String [] array = br.readLine().trim().split(" ");
			long [] time = new long[n];
			for(int i=0;i<n;i++){
				time[i] = Long.parseLong(array[i]);
			}

			String [] params = br.readLine().trim().split(" ");
			long c = Long.parseLong(params[0])-1;
			long d = Long.parseLong(params[1]);
			long s = Long.parseLong(params[2]);

			long travelTime = d/s;
			
			long car1 = time[0];
			long car2 = time[0] + time[0];

			long total = time[0];
			for(int i=1;i<n;i++){
				car1 += travelTime + time[i];
				car2 += travelTime + time[i];
				
				if(car2-car1<time[i]){
					long delay = (time[i]-(car2-car1));
					car2 += (time[i]-(car2-car1));
					total += delay;	
				}
			}
			System.out.println(total*(c));
		}
	}
}