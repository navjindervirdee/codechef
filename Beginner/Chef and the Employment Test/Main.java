import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			int n = input.nextInt();
			int k = input.nextInt();
			int [] array = new int[n];
			for(int i=0;i<n;i++){
				array[i] = input.nextInt();
			}

			Arrays.sort(array);
			System.out.println(array[(n+k)/2]);
			System.out.println(Math.pow(2,15));
		}
	}
}