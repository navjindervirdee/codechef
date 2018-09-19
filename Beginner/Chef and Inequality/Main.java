import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int k=0;k<t;k++){
			long a = input.nextInt();
			long b = input.nextInt();
			long c = input.nextInt();
			long d = input.nextInt();
			long e = 1;
			long f = 2;

			long count = 0;
			for(long i=a;i<b+1;i++){
				count = count + Math.max((d-Math.max(c,i+1)+1),0);
				
			}
			System.out.println(count);

			/*long ans = 0;

			if(d<=a){
				ans = 0;
			}
			else{
				if(c>=b){
					if(c>b){
						ans = (b-a+e)*(d-c+e);
					}
					else{
						ans = (b-a)*(d-c+e) + (d-c);
					}
				}

				else{
					if(d<=b){
						if(c<a){
							c=a;
						}
						if(d<b){
							b=d;
						}
						//System.out.println(a + " " + b + " " + c + " " + d);
						if(a<c){
							ans = ans + (c-a)*(d-c+e);
							a = c;
						}
						//System.out.println(ans);
						if(a==c && d==b){
							ans = ans + ((b-a)*(b-a+e))/f;
						}
						//System.out.println(ans);
					}
				
					else{
						if(d>b){
							if(c<a){
								c=a;
							}
							ans = ans + (d-b)*(b-a+e) + ((b-c)*(b-c+e))/f;
							if(c>a){
								ans = ans + (c-a)*(d-c+e);
							}
						}
					}
				}
			}
			if(a>b || c>d){
				ans = 0;
			}
			System.out.println(ans);*/
		}
	}
}