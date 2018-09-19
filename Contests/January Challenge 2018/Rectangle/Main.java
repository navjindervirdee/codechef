import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int i=0;i<t;i++){
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			int d = input.nextInt();

			if(a==b && c==d){
				System.out.println("YES");
				continue;
			}
			if(a==c && b==d){
				System.out.println("YES");
				continue;
			}
			if(a==d && c==b){
				System.out.println("YES");
				continue;
			}
			System.out.println("NO");
		

		}
	}
}