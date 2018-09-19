import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int i=0;i<t;i++){
			int n = input.nextInt();
			int k = input.nextInt();
			int s = input.nextInt();
			
			int count = 0;
			int days = 0;
			int left = 0;
			int prev = -1;
			while(s>days){
				//System.out.println(days + " " + count + " " + prev + " " + left);
				if(left<k){
					if(days%7==6 && prev==days-1){
						count = -1;
						break;
					}
					else{
						left += n;
						count++;
						if(days%7!=6){
							left -= k;
							days++;
						}
						prev = days-1;
					}
					continue;
				}
				days++;
				left -= k;
			}
			System.out.println(count);
		}
	}
}