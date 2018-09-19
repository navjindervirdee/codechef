import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			int n = input.nextInt();
			int [] array = new int[n];
			for(int i=0;i<n;i++){
				array[i] = input.nextInt();
			}

			int [] a = new int[n];
			int [] b = new int[n];
			for(int i=0;i<n;i++){
				a[i] = array[i] & ((1<<16)-1);
				b[i] = array[i] >> 16;
			}
			System.out.println("Case " + (c+1) + ":");
			for(int i=0;i<n;i++){
				System.out.print(a[i] + " ");
			}
			System.out.println();
			for(int i=0;i<n;i++){
				System.out.print(b[i] + " ");
			}
			System.out.println();
		}
	}
}