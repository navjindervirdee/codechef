import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for(int c=0;c<t;c++){
			String [] params = br.readLine().trim().split(" ");
			int n = Integer.parseInt(params[0]);
			int m = Integer.parseInt(params[1]);
			int x = Integer.parseInt(params[2]);
			int k = Integer.parseInt(params[3]);

			int evenMon = m/2;
			int oddMon = m-evenMon;

			int maxEvenPatents = evenMon*x;
			int maxOddPatents = oddMon*x;

			String workdays = br.readLine().trim();
			int evenWorkers = 0;
			int oddWorkers = 0;
			for(int i=0;i<workdays.length();i++){
				char ch = workdays.charAt(i);
				if(ch=='E'){
					evenWorkers++;
				}
				else{
					oddWorkers++;
				}
			}
			
			maxEvenPatents = Math.min(evenWorkers,maxEvenPatents);
			maxOddPatents = Math.min(oddWorkers,maxOddPatents);
			int sum = maxOddPatents + maxEvenPatents;
			if(sum>=n){
				System.out.println("yes");
			}
			else{
				System.out.println("no");
			}
		}
	}
}