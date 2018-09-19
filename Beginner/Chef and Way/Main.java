import java.util.*;
import java.math.*;
public class Main{
	static class Element implements Comparable<Element>{
		int index;
		double value;

		public Element(int index, double value){
			this.index = index;
			this.value = value;
		}

		public int compareTo(Element e){
			if(this.value<e.value){
				return -1;
			}
			if(this.value>e.value){
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		Element [] array = new Element[n];
		long [] result =  new long[n];
		int mod = 1000000007;
		for(int i=0;i<n;i++){
			result[i] = input.nextInt();
			if(result[i]==1){
				array[i] = new Element(i,0.1);
			}
			else{
				array[i] =  new Element(i,Math.log(result[i]));
			}
			result[i] = result[i]%mod;
		}

		Queue<Element> queue = new PriorityQueue<Element>();
		queue.add(array[0]);
		
		for(int i=1;i<n;i++){
			if(i-k-1 > -1){
				queue.remove(array[i-k-1]);
			}
			Element e = array[i];
			Element min = queue.peek();
			e.value = e.value + min.value;
			result[i] = (result[min.index]*result[i])%mod;
			queue.add(e);
		}
		System.out.println(result[n-1]);
	}
}