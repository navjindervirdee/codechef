import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			int n = input.nextInt();
			input.nextLine();
			long [][] array = new long[n][n];
			for(int i=0;i<n;i++){
				String [] nums = input.nextLine().trim().split(" ");
				for(int j=0;j<n;j++){
					array[i][j] = Integer.parseInt(nums[j]);
				}
			}

			for(int i=0;i<n;i++){
				Arrays.sort(array[i]);
			}

			long sum = 0;
			long prev = Integer.MAX_VALUE;
			boolean found = false;
			for(int i=n-1;i>-1;i--){
				found = false;
				for(int j=n-1;j>-1;j--){
					if(array[i][j]<prev){
						sum += array[i][j];
						found = true;
						prev = array[i][j];
						break;
					}
				}
				if(!found){
					sum = -1;
					break;
				}
			}

			System.out.println(sum);
		}
	}
}