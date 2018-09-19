import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			String a = Integer.toString(input.nextInt());
			String b = Integer.toString(input.nextInt());
			int i = a.length()-1;
			int j = b.length()-1;
			String result = "";
			while(i>-1 && j>-1){
				int num1 = Integer.parseInt(Character.toString(a.charAt(i)));
				int num2 = Integer.parseInt(Character.toString(b.charAt(j)));
				int v = num1+num2;
				String num3 = Integer.toString(v);
				result = num3.charAt(num3.length()-1) + result;
				i--;
				j--;
			}
			if(j>-1){
				while(j>-1){
					result = b.charAt(j) + result;
					j--;
				}
			}
			else{
				while(i>-1){
					result = a.charAt(i) + result;
					i--;
				}
			}
			System.out.println(result);
		}

	}
}