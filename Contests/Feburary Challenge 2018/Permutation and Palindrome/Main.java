import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int t = Integer.parseInt(input.nextLine().trim());
		for(int c=0;c<t;c++){
			Map<Character,List<Integer>> map = new HashMap<Character,List<Integer>>();
			String array = input.nextLine().trim();

			for(int i=0;i<array.length();i++){
				char ch = array.charAt(i);
				if(map.containsKey(ch)){
					List<Integer> list = map.get(ch);
					list.add(i);
					map.put(ch,list);
					continue;
				}
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(ch,list);
			}

			int [] perm = new int[array.length()];
			int i=0;
			int j=perm.length-1;

			boolean possible = true;
			int numOdd = 0;
			char oddChar = '-';
			for(char ch : map.keySet()){
				List<Integer> list = map.get(ch);
				if(list.size()%2!=0){
					if(numOdd==1){
						possible = false;
						break;
					}
					numOdd++;
					oddChar = ch;
					continue;
				}
				int k=0;
				while(k<list.size()/2){
					perm[i] = list.get(k);
					i++;
					k++;
				}
				while(k<list.size()){
					perm[j] = list.get(k);
					k++;
					j--;
				}
			}
			if(possible){
				if(numOdd==1){
					List<Integer> list = map.get(oddChar);
					int k=0;
					while(i<=j){
						perm[i] = list.get(k);
						k++;
						i++;
					}
				}
				for(i=0;i<perm.length;i++){
					System.out.print((perm[i]+1) + " ");
				}
				System.out.println();
			}
			else{
				System.out.println(-1);
			}
		}
	}
}