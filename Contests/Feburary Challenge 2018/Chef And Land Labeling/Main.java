import java.util.*;
public class Main{
	private static int numDiv(int num1, int num2){
		int min = Math.min(num1, num2);
		int count = 0;
		for(int i=1;i<=min/2;i++){
			if(num1%i==0 && num2%i==0){
				count++;
			}
		}
		if(num1%min==0 && num2%min==0){
			count++;
		}
		return count;
	}

	private static int [][] getDiv(int n){
		int [][] array = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==j){
					array[i][j] = 0;
					continue;
				}
				array[i][j] = numDiv(i+1,j+1);
			}
		}
		return array;
	}

	private static String makeString(Map<Integer,Integer> map, SortedSet<Integer> set){
		StringBuilder sb = new StringBuilder();
		for(int key : set){
			int value = map.get(key);
			sb.append(Integer.toString(value)+"-");
		}
		return sb.toString();	
	}

	private static Map<String,Set<Integer>> getValues(int [][] array){
		Map<String,Set<Integer>> map = new HashMap<String,Set<Integer>>();
		for(int i=0;i<array.length;i++){
			Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
			SortedSet<Integer> set = new TreeSet<Integer>();
			for(int j=0;j<array.length;j++){
				if(temp.containsKey(array[i][j])){
					temp.put(array[i][j],temp.get(array[i][j])+1);
					continue;
				}
				temp.put(array[i][j],new Integer(1));
				set.add(array[i][j]);
			}
			
			String s = makeString(temp,set);

			if(map.containsKey(s)){
				Set<Integer> st =  map.get(s);
				st.add(i+1);
				map.put(s,st);
				continue;
			}
			Set<Integer> st = new TreeSet<Integer>();
			st.add(i+1);
			map.put(s,st);
		}
		return map;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int c=0;c<t;c++){
			int n = input.nextInt();
			int [][] array = new int[n][n];
			
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					array[i][j] = input.nextInt();
				}
			}

			int [][] div = getDiv(n);
			Map<String,Set<Integer>> map = getValues(div);
			int [] result = new int[n];

			for(int i=0;i<array.length;i++){
				Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
				SortedSet<Integer> set = new TreeSet<Integer>();
				for(int j=0;j<array.length;j++){
					if(temp.containsKey(array[i][j])){
						temp.put(array[i][j],temp.get(array[i][j])+1);
						continue;
					}
					temp.put(array[i][j],new Integer(1));
					set.add(array[i][j]);
				}
				
				String s = makeString(temp,set);

				Set<Integer> st = map.get(s);
				List<Integer> list = new ArrayList<Integer>(st);
				int num = list.get(0);
				st.remove(num);
				map.put(s,st);
				result[i] = num;
			}

			for(int i=0;i<n;i++){
				System.out.println(result[i]);
			}
		}

		
	}
}