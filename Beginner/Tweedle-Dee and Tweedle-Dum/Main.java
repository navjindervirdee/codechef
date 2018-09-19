import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		input.nextLine();
		for(int c=0;c<t;c++){
			String n_name [] = input.nextLine().trim().split(" ");
			int n = Integer.parseInt(n_name[0]);
			String name = n_name[1];
			String [] array = input.nextLine().trim().split(" ");
			if(n==1 && name.equals("Dee") && Integer.parseInt(array[0])%2==0){
				System.out.println("Dee");
			}
			else{
				System.out.println("Dum");
			}
		}

	}
}
