import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		List<String> list = new ArrayList<String>();
		for(int i=0;i<s.length();i++){
			for(int j=s.length();j>i;j--){
				String str = s.substring(i,j);
				list.add(str);
			}
		}

		Collections.sort(list);
		String hidden = "";
		for(int i=0;i<list.size();i++){
				hidden += list.get(i);
		}

		//System.out.println(hidden);

		int q = input.nextInt();
		long g = 0;
		for(int i=0;i<q;i++){
			long p = input.nextInt();
			long m = input.nextInt();

			long index = ((p*g)%m);

			g = g + (long)(hidden.charAt((int)index));
			//System.out.println(index + " " + g);
			System.out.println(hidden.charAt((int)index));
		}
	}
}