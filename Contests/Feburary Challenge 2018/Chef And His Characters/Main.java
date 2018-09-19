import java.util.*;
import java.io.*;
public class Main{
	private static void makeSet(Set<Character> set){
		set.add('c');
		set.add('h');
		set.add('e');
		set.add('f');
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int t = Integer.parseInt(br.readLine().trim());
		Set<Character> set = new HashSet<Character>();
		makeSet(set);
		for(int c=0;c<t;c++){
			String str = br.readLine().trim();
			int count = 0;
			int i =0;
			while(i<str.length()-4+1){
				Set<Character> temp = new HashSet<Character>(set);
				boolean inset = true;
				for(int j=i;j<i+4;j++){
					char ch = str.charAt(j);
					if(!temp.contains(ch)){
						if(!set.contains(ch)){
							i = j+1;
							inset = false;
						}
						break;
					}
					temp.remove(ch);
				}
				if(temp.size()==0){
					count++;
				}
				if(inset){
					i++;
				}
			}

			if(count==0){
				System.out.println("normal");
			}
			else{
				System.out.println("lovely " + count);
			}
		}
	}
}