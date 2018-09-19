import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			int n = input.nextInt();
			input.nextLine();
			Set<String> set = new HashSet<String>();
			for(int i=0;i<n;i++){
				set.add(input.nextLine().trim());
			}

			if(!set.contains("cakewalk") || !set.contains("simple") || !set.contains("easy")){
				System.out.println("No");
			}
			else{
				if((set.contains("easy-medium") || set.contains("medium")) && (set.contains("medium-hard") || set.contains("hard"))){
					System.out.println("Yes");
				}
				else{
					System.out.println("No");
				}
			}
		}
	}
}