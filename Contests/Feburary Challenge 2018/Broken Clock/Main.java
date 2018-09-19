import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//System.out.println(Math.sin((Math.asin(1.0/2.0))));
		int h = input.nextInt();
		input.nextLine();
		for(int c=0;c<h;c++){
			String[] params = input.nextLine().trim().split(" ");
			double l = Long.parseLong(params[0]);
			double d = Long.parseLong(params[1]);
			double t = Long.parseLong(params[2]);

			System.out.println(l + " " + d + " " + t);

			double angle = Math.toDegrees(Math.asin(d/l));
			System.out.println(angle);

			double temp = angle;
			if(d>=0.0){
				temp = 90.0 - angle;
			}
			else{
				temp += 90.0;
			}

			System.out.println(temp);
			double timein360 = 360.0/temp;
			System.out.println(timein360);

			double left = t%timein360;

			System.out.println(left);

			temp = left*temp;
			System.out.println(temp);

			long mul = 1;
			if(temp>180.0){
				temp = 360.0 - temp;
			}

	
			if(temp>90){
				mul = -1;
				temp -= 90;
			}		
			else{
				mul = 1;
				temp = 90 - temp;
			}

			System.out.println(temp + " " + Math.sin(Math.toRadians(temp))*l);
			
			long y = (long)(Math.ceil(Math.sin(Math.toRadians(temp))*l));

			y = y*mul;
			long mod = 1000000007;
			y = ((y%mod)+mod)%mod;
			//System.out.println(y + " " + (-1%9));

			System.out.println(y);
		}
	}
}