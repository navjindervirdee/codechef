import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		input.nextLine();
		for(int c=0;c<t;c++){
			long sum = 8+6+4+2;
			Set<Long> set =  new HashSet<Long>();
			set.add(new Long(8));
			set.add(new Long(6));
			set.add(new Long(4));
			set.add(new Long(2));

			List<Long> list = new ArrayList<Long>();
			String [] in = input.nextLine().trim().split(" ");
			long k = Long.parseLong(in[0]);
			long d0 = Long.parseLong(in[1]);
			long d1 = Long.parseLong(in[2]);

			long s = d0 + d1;
			k -= 2;
			boolean zero = false;
			while(k > 0 && !set.isEmpty()){
				long temp = s%10;
				if(temp==0){
					zero = true;
					break;
				}
				s += temp;
				if(set.contains(temp)){
					set.remove(temp);
					list.add(temp);
				}
				k--;
			}
			if(zero){
				if(s%3==0){
					System.out.println("YES");
				}
				else{
					System.out.println("NO");
				}
				continue;
			}

			if(k==0){
				if(s%3==0){
					System.out.println("YES");
				}
				else{
					System.out.println("NO");
				}
				continue;
			}

			long q = k/4;
			long r = k%4;
			s += sum*q;

			for(int i=0;i<r;i++){
				s += list.get(i);
			}

			if(s%3==0){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
	}
}