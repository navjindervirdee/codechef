import java.util.*;
public class Main{
	private static long getGcd(long a, long b){
		if(a%b==0){
			return b;
		}
		return getGcd(b,a%b);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			int n = input.nextInt();
			long [] array =  new long[n];
			for(int i=0;i<n;i++){
				array[i] = input.nextInt();
			}

			long min = Long.MAX_VALUE;
			for(int i=0;i<n-1;i++){
				for(int j=i+1;j<n;j++){
					long gcd = getGcd(array[i],array[j]);
					long lcm = (array[i]*array[j])/gcd;
					if(min>lcm){
						min = lcm;
					}
				}
			}
			System.out.println(min);
		}
	}
}