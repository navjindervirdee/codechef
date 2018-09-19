import java.util.*;
public class Main{
	private static List<Character> filterString(String str){
		char prev = '.';
		List<Character> list = new ArrayList<Character>();
		for(int i=0;i<str.length();i++){
			char temp = str.charAt(i);
			if(temp!=prev){
				list.add(temp);
				prev = temp;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			int n = input.nextInt();
			int m = input.nextInt();
			input.nextLine();
			String a = input.nextLine().trim();
			String b = input.nextLine().trim();

			List<Character> lista = filterString(a);
			List<Character> listb = filterString(b);

			int [][] array = new int[lista.size()+1][listb.size()+1];
			for(int i=0;i<array.length;i++){
				array[i][0] = i;
			}

			for(int i=0;i<array[0].length;i++){
				array[0][i] = i;
			}

			for(int i=1;i<array.length;i++){
				for(int j=1;j<array[0].length;j++){
					if(lista.get(i-1)==listb.get(j-1)){
						array[i][j] = array[i-1][j-1] + 1;
						continue;
					}
					array[i][j] = Math.min(array[i-1][j],array[i][j-1]) + 1;
				}
			}

			System.out.println(array[array.length-1][array[0].length-1]);
		}
	}
}