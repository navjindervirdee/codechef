import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in)		;
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			int n = input.nextInt();
			int m = input.nextInt();

			int [] low = new int[m];
			int [] high = new int[m];

			for(int i=0;i<m;i++){
				low[i] = input.nextInt();
				high[i] = input.nextInt();
			}

			int [][] scores = new int[n][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					scores[i][j] = input.nextInt();
				}
			}

			int iters =  300;
			int [] result = new int[m];
			int min = Integer.MAX_VALUE;
			for(int k=0;k<iters;k++){
				int [] temp = new int[m];
				for(int i=0;i<m;i++){
					temp[i] = low[i] + (int)(Math.random()*((high[i]-low[i])+1));
				}

				int [] table =  new int[n];
				for(int i=0;i<n;i++){
					int score = 0;
					for(int j=0;j<m;j++){
						score += scores[i][j]*temp[j];
					}
					table[i] = score;
				}

				int count =0 ;
				for(int i=0;i<n-1;i++){
					for(int j=i+1;j<n;j++){
						if(table[i]<table[j]){
							count++;
						}
					}	
				}

				if(count<min){
					result = temp;
					min = count;
				}
			}

			for(int i=0;i<m;i++){
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
	}
}