import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner  input = new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			int n = input.nextInt();
			input.nextLine();
			Map<String,Integer> map = new HashMap<String,Integer>();
			for(int i=0;i<n;i++){
				String team = input.nextLine().trim();
				if(map.containsKey(team)){
					map.put(team,map.get(team)+1);
					continue;
				}	
				map.put(team,new Integer(1));
			}
			//System.out.println(map);
			int [] array = new int[2];
			int i = 0;
			String [] teams = new String[2];
			for(String key : map.keySet()){
				array[i] = map.get(key);
				teams[i] = key;
				i++;
			}

			if(array[0]==array[1]){
				System.out.println("Draw");
			}
			else{
				if(array[0]>array[1]){
					System.out.println(teams[0]);
				}
				else{
					System.out.println(teams[1]);
				}
			}
			
		}
	}
}