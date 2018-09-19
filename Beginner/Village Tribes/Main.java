import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		input.nextLine();
		for(int c=0;c<t;c++){
			char [] line = input.nextLine().trim().toCharArray();
			char prev = '?';
			Map<Character,Integer> villages = new HashMap<Character,Integer>();
			villages.put('A',new Integer(0));
			villages.put('B',new Integer(0));
			int countdot = 0;
			for(int i=0;i<line.length;i++){
				if(line[i]=='A'){
					int count  = 1;
					if(prev == 'A'){
						count = count + countdot;
					}
					countdot=0;
					villages.put('A',villages.get('A') + count);
					prev = 'A';
					continue;
				}
				if(line[i]=='B'){
					int count = 1;
					if(prev == 'B'){
						count += countdot;
					}
					countdot = 0;
					villages.put('B',villages.get('B')+count);
					prev = 'B';
					continue;
				}
				countdot++;
			}
			System.out.println(villages.get('A') + " " + villages.get('B'));
		}
	}
}
