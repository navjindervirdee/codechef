import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n = Long.parseLong(input.nextLine().trim());
		long i = 4;
		long count = 0;
		long num = -1;
		while(count<n){
			if(i%2==0){
				long j = 2;
				boolean simplify  =false;
				while((j*j)<=i){
					if((i%(j*j))==0){
						simplify = true;
						break;
					}
					j = j + 2;
				}
				if(simplify){
					num = i;
					count++;
				}
			}
			else{
				long j = 3;
				boolean simplify = false;
				while((j*j)<=i){
					if((i%(j*j))==0){
						simplify = true;
						break;
					}
					j = j + 2;
				}
				if(simplify){
					count++;
					num = i;
				}
			}
			//System.out.println(num);
			i++;
		}
		System.out.println(num);
	}
}