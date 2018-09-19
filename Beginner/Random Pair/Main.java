import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			int n = input.nextInt();
			int [] array = new int[n];
			for(int i=0;i<n;i++){
				array[i] = input.nextInt();
			}
			Map<Integer,Integer> count = new HashMap<Integer,Integer>();
			int max = -1;
			double total = 0;
			for(int i=0;i<n-1;i++){
				for(int j=i+1;j<n;j++){
					total++;
					int sum = array[i] + array[j];
					if(max<sum){
						max = sum;
					}
					if(count.containsKey(sum)){
						count.put(sum,count.get(sum)+1);
						continue;
					}
					count.put(sum,new Integer(1));
				}
			}
			double favcount = count.get(max);
			System.out.println(favcount/total);
		}
	}
}