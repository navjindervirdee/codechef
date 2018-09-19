import java.util.*;
public class Main{
	private static long [] maxSum(long [] array){
		long max_so_far = array[0];
		long max_ending_here = array[0];
		long start = 0;
		long end = 0;
		for(int i=1;i<array.length;i++){
			if(max_ending_here < array[i]){
				start = i;
			}
			max_ending_here = Math.max(array[i] + max_ending_here,array[i]);

			if(max_so_far < max_ending_here){
				max_so_far = max_ending_here;
				end = i;
			}
		}
		
		long [] result = new long[3];
		result[0] = max_so_far;
		result[1] = start;
		result[2] = end;
		return result;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			int n = input.nextInt();
			long k = input.nextInt();
			long [] array = new long[n];

			long poscount = 0;
			long s = 0;
			long maxneg = Integer.MIN_VALUE;

			for(int i=0;i<n;i++){
				array[i] = input.nextInt();
				maxneg = Math.max(maxneg,array[i]);
				if(array[i]>=0){
					poscount++;
					s += array[i];
				}
			}

			//all positive
			if(poscount==array.length){
				System.out.println(s*k);
				continue;
			}

			//all negative
			if(poscount==0){
				System.out.println(maxneg);
				continue;
			}

			//subtask1
			long p = n;
			if(p*k<100000000){
				long array3 [] = new long[n*((int)k)];
				int l = 0;
				int j = 0;
				while(l<k){
					for(int i=0;i<n;i++){
						array3[j] =array[i];
						j++;
					}
					l++;
				}
				System.out.println(maxSum(array3)[0]);
				continue;
			}


			//subtask2
			long [] result = maxSum(array);
			long max1 = result[0];

			if(k==1){
				System.out.println(max1);
				continue;
			}

			long sum = 0;
			for(int i=0;i<array.length;i++){
				sum += array[i];
			}
			long diff = sum - max1;
			
			max1 = Math.max(max1,max1*k + (k-1)*diff);
			
			for(int i=0;i<array.length;i++){
				array[i] = -1*array[i];
			}

			result = maxSum(array);
			long max2 = sum + result[0];

			diff = sum - max2;
			
			long m = max2;
			max2 = Math.max(max2,(k-1)*m+(k-2)*diff);
			max2 = Math.max(max2,k*m + k*diff);


			max2 = Math.max(max1,max2);
			System.out.println(max2);
		}
	}
}