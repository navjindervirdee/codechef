import java.util.*;
public class Main{
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			int n = input.nextInt();
			int m = input.nextInt();

			input.nextLine();

			char [][] array1 = new char[n][m];
			char [][] array2 = new char[n][m];

			for(int j=0;j<m;j++){
				if(j%2==0){
					array1[0][j] = 'R';
					array2[0][j] = 'G';
				}
				else{
					array1[0][j] = 'G';
					array2[0][j] = 'R';
				}

				for(int i=1;i<n;i++){
					array1[i][j] = array2[i-1][j];
					array2[i][j] = array1[i-1][j];
				}
			}

			
			String [] array3 = new String[n];
			for(int i=0;i<n;i++){
				array3[i] = input.nextLine().trim();
			}

			int cost1 = 0;
			int cost2 = 0;

			for(int i=0;i<n;i++){
				char [] arr = array3[i].toCharArray();
				for(int j=0;j<m;j++){
					if(arr[j]=='R'){
						if(array1[i][j]!='R'){
							cost1 += 5;
						}
						if(array2[i][j]!='R'){
							cost2 += 5;
						}
					}
					else{
						if(array1[i][j]!='G'){
							cost1 += 3;
						}
						if(array2[i][j]!='G'){
							cost2 += 3;
						}
					}
				}
			}

			System.out.println(Math.min(cost1,cost2));


		}

	}
}