import java.util.*;
public class Main{
	private static boolean findSet(long sum,  Set<Long> set,long [] array,int index){
		if(sum==0){
			return true;
		}
		if(index >= array.length || sum<array[index]){
			return false;
		}
		set.add(array[index]);
		boolean found = findSet(sum-array[index],set,array,index+1);
		if(found){
			return true;
		}
		set.remove(array[index]);
		found = findSet(sum,set,array,index+1);
		if(found){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			long x = input.nextInt();
			long n = input.nextInt();

			long sum = (n*(n+1))/2 - x;
			long mod = 2;
			long one = 1;
			if(sum%mod!=0 || n==mod){
				System.out.println("impossible");
				continue;
			}

			sum = sum/mod;
			int end = (int)n;
			
			Set<Long> set = new HashSet<Long>();
			long [] array =  new long[end-1];
			int index = 0;
			for(long i=1;i<n+1;i++){
				if(i==x){
					continue;
				}
				array[index] = i;
				index++;
			}

			long temp = sum;
			long e = end;
			while(temp>0 && e>0){
				if(e==x || e>temp){
					e--;
					continue;
				}
				temp -= e;
				set.add(e);
				e--;
			}
			if(temp==0){
				for(long i=1;i<n+1;i++){
					if(i==x){
						System.out.print(2);
						continue;
						}
					if(set.contains(i)){
						System.out.print(1);
						continue;
					}
					System.out.print(0);
				}
				System.out.println();
				continue;
			}

			temp = sum;
			long start = 1;
			set = new HashSet<Long>();
			while(temp>0 && start<=temp){
				if(start==x){
					start++;
					continue;
				}
				temp -= start;
				set.add(start);
				start++;
			}

			if(temp==0){
				for(long i=1;i<n+1;i++){
					if(i==x){
						System.out.print(2);
						continue;
						}
					if(set.contains(i)){
						System.out.print(1);
						continue;
					}
					System.out.print(0);
				}
				System.out.println();
				continue;
			}
			
			boolean found = findSet(sum,set,array,0);
			if(!found){
				System.out.println("impossible");
				continue;
			}
			for(long i=1;i<n+1;i++){
				if(i==x){
					System.out.print(2);
					continue;
					}
				if(set.contains(i)){
					System.out.print(1);
					continue;
				}
				System.out.print(0);
			}
			System.out.println();
		}

	}
}