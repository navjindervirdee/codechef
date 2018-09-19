import java.util.*;
import java.io.*;
public class Main{
	private static int findDay(long [] array, long left){
		long sum = 0;
		int day = -1;
		while(sum<left){
			day++;
			sum += array[day];
		}
		return day;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(0,"Monday");
		map.put(1,"Tuesday");
		map.put(2,"Wednesday");
		map.put(3,"Thursday");
		map.put(4,"Friday");
		map.put(5,"Saturday");
		map.put(6,"Sunday");

		for(int c=0;c<t;c++){
			long k = input.nextInt();
			long [] array = new long[7];
			for(int i=0;i<array.length;i++){
				array[i] = input.nextInt();
			}
			long sum = 0;
			int day = -1;
			
			for(int i=0;i<array.length;i++){
				sum += array[i];
			}
			
			if(sum>=k){
				day = findDay(array,k);
			}
			else{
				if(k%sum==0){
					day = findDay(array,sum);
				}
				else{
					day = findDay(array,k%sum);
				}
			}
			System.out.println(map.get(day));
		}
	}
}