import java.util.*;
public class Main{
	private static String getBinary(int x){
		String binary = "";
		while(x!=0){
			int r = x%2;
			x = x/2;
			binary = r + binary;
		}
		return binary;
	}

	private static int checkAlive(Set<Integer> set, int alive, int [] array,int y){
		for(int key : set){
			if(key<array.length && array[key]>0){
				array[key] -= y;
				if(array[key]<=0){
					alive--;
				}
			}
		}
		return alive;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		int [] array = new int[n];
		int alive = 0;
		String [] str = input.nextLine().trim().split(" ");
		Map<Integer,HashSet<Integer>> map = new HashMap<Integer,HashSet<Integer>>();
		int ones = 1;
		HashSet<Integer> list = new HashSet<Integer>();
		map.put(ones,list);
		
		for(int i=0;i<str.length;i++){
			array[i] = Integer.parseInt(str[i]);
			if(i>ones){
				ones = ones*2+1;
				HashSet<Integer> newlist = new HashSet<Integer>();
				map.put(ones,newlist);
			}
			if(array[i]>0){
				alive++;
				HashSet<Integer> temp = map.get(ones);
				temp.add(i);
				map.put(ones,temp);
			}
		}

		//System.out.println(map + " " + alive);

		int q = input.nextInt();
		for(int i=0;i<q;i++){
			int x = input.nextInt();
			int y = input.nextInt();

			char [] binary = getBinary(x).toCharArray();
			boolean allones = true;
			for(int j=0;j<binary.length;j++){
				if(binary[j]=='0'){
					allones = false;
					break;
				}
			}

			if(allones){
				int temp = 1;
				while(temp<=x){
					if(!map.containsKey(temp)){
						break;
					}
					HashSet<Integer> list1 = map.get(temp);
					HashSet<Integer> list2 = new HashSet<Integer>(list1);
					for(int key : list2){
						int index = key;
						array[index] -= y;
						if(array[index]<=0){
							alive--;
							list1.remove(key);
						}
					}
					if(list1.size()==0){
						map.remove(temp);
					}
					else{
						map.put(temp,list1);
					}
					temp = temp*2+1;
				}
				System.out.println(alive);
				continue;
			}

			Set<Integer> set = new HashSet<Integer>();
			int prev = 0;
			int pow = 0;
			set.add(prev);
			
			for(int j=binary.length-1;j>-1;j--){
				if(binary[j]=='1'){
					prev = prev + ((int)Math.pow(2,pow));
				}
				pow++;
				if(prev>n){
					break;
				}
			
				if(set.contains(prev)){
					continue;
				}
				Set<Integer> temp = new HashSet<Integer>(set);
				for(int key : temp){
					int num = prev - key;
					set.add(num);
				}
			}

			alive = checkAlive(set,alive,array,y);
			System.out.println(alive);
		}
	}
}