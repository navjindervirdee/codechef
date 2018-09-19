import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		input.nextLine();
		for(int c=0;c<t;c++){
			String [] n_p = input.nextLine().trim().split(" ");
			int n = Integer.parseInt(n_p[0]);
			int p = Integer.parseInt(n_p[1]);
			int cakewalk = p/2;
			int hard = p/10;

			int countCakewalk = 0;
			int countHard = 0;

			String [] array = input.nextLine().trim().split(" ");

			for(int i=0;i<array.length;i++){
				int num = Integer.parseInt(array[i]);
				if(num>=cakewalk){
					countCakewalk++;
				}
				if(num<=hard){
					countHard++;
				}
			}

			if(countCakewalk==1 && countHard==2){
				System.out.println("yes");
			}
			else{
				System.out.println("no");
			}
		}
	}
}