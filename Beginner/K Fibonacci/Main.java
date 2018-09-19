import java.util.*;
public class Main{
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int mod = 1000000007;
		if(n<=k){
			System.out.println(1);
		}
		else{
			int [] array = new int[n+1];
			array[k+1] = k%mod;
			for(int i=k+2;i<array.length;i++){
				array[i] = (array[i-1]*2)%mod;
				if(i-k-1<=k){
					array[i]--;
				}
				else{
					array[i] = (array[i] - array[i-k-1])%mod;
				}
			}
			System.out.println(array[n]);
		}
	}
}