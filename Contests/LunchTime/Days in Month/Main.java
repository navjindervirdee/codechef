import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		input.nextLine();
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("mon",new Integer(0));
		map.put("tues",new Integer(1));
		map.put("wed",new Integer(2));
		map.put("thurs",new Integer(3));
		map.put("fri",new Integer(4));
		map.put("sat",new Integer(5));
		map.put("sun",new Integer(6));
		for(int c=0;c<t;c++){
			String n_day [] = input.nextLine().trim().split(" ");
			int n = Integer.parseInt(n_day[0]);
			int day = map.get(n_day[1]);
			Map<Integer,Integer> days = new HashMap<Integer,Integer>();
			days.put(new Integer(0),new Integer(0));
			days.put(new Integer(1),new Integer(0));
			days.put(new Integer(2),new Integer(0));
			days.put(new Integer(3),new Integer(0));
			days.put(new Integer(4),new Integer(0));
			days.put(new Integer(5),new Integer(0));
			days.put(new Integer(6),new Integer(0));
			//map.put(day,map.get(day)+1);
			int count = 1;
			while(count<=n){
				days.put(day,days.get(day)+1);
				count = count+7;
			}
			int startday = day;
			if(count>n){
				count = count-7+1;
				day = (day+1)%7;
				while(count<=n){
					days.put(day,days.get(day)+1);
					day = (day+1)%7;
					count++;
				}
			}
			for(int i=0;i<7;i++){
				if(i!=startday){
					days.put(i,days.get(i)+days.get(startday)-1);
				}
				System.out.print(days.get(i) + " ");
			}
			System.out.println();
			

		}
	}
}