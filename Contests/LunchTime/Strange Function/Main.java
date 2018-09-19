import java.util.*;
import java.math.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		input.nextLine();
		for(int c = 0;c<t;c++){
			String a_n [] = input.nextLine().trim().split(" ");
			long a = Long.parseLong(a_n[0]);
			long n = Long.parseLong(a_n[1]);
			Map<Long,Integer> map = new HashMap<Long,Integer>();
			int ans = 0;
			if(a==0){
				ans = 0;
			}
			else{
				if(a%9==0){
					ans = 9;
				}
				else{
					ans = (int)(a%9);
				}
			}
			long exp = 1;
			map.put(exp,ans);
			int prev = ans;
			while(exp*2<=n){
				prev = (prev*prev)%9;
				if(prev==0){
					prev=9;
				}
				exp = exp*2;
				map.put(exp,prev);
			}

			ans = map.get(exp);
			n = n-exp;
			while(n>1){
				if(exp>n){
					exp = exp/2;
					continue;
				}
				ans = (ans*map.get(exp))%9;
				if(ans==0){
					ans = 9;
				}
				n = n-exp;
				
			}
			if(n==0){
				System.out.println(ans);
			}
			if(n==1){
				ans = (ans * map.get(new Long(1)))%9;
				if(ans==0){
					ans = 9;
				}
				System.out.println(ans);
			}
		}

	}
}