import java.util.*;
import java.io.*;
public class Main{
	static class Segment{
		int start;
		int end;
		int index;

		public Segment(int start, int end, int index){
			this.start = start;
			this.end = end;
			this.index = index;
		}
	}

	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for(int c=0;c<t;c++){
			int n = Integer.parseInt(br.readLine().trim());
			int [] segmentPoints = new int[n];
			Segment [] segments1 = new Segment[n];
			Segment [] segments2 = new Segment[n];

			for(int i=0;i<n;i++){
				String [] segment = br.readLine().trim().split(" ");
				int start = Integer.parseInt(segment[0]);
				int end = Integer.parseInt(segment[1]);
				Segment seg = new Segment(start,end,i);
				segments1[i] = seg;
				segments2[i] = seg;
			}

			Arrays.sort(segments1, new Comparator<Segment>(){
				public int compare(Segment s1, Segment s2){
					if(s1.start<s2.start){
						return -1;
					}
					if(s1.start==s2.start){
						return s1.end-s2.end;
					}
					else{
						return 1;
					}
				}
			});

			Arrays.sort(segments2, new Comparator<Segment>(){
				public int compare(Segment s1, Segment s2){
					if(s1.end<s2.end){
						return -1;
					}
					if(s1.end==s2.end){
						return s1.start-s2.start;
					}
					else{
						return 1;
					}
				}
			});

			int q = Integer.parseInt(br.readLine().trim());
			for(int b=0;b<q;b++){
				String [] query = br.readLine().trim().split(" ");
				int m = Integer.parseInt(query[0]);
				//System.out.println("M" + " " + m);
				int [] points = new int[m];
				for(int j=0;j<m;j++){
					points[j] = Integer.parseInt(query[j+1]);
				}
				Arrays.sort(points);
				int total = 0;

				int i=0;
				int j=0;
				int k=0;
				
				while(j<n){
					//System.out.println(i + " " + j + " " + k);
					if(i<n && (k>m-1 || segments1[i].start<=points[k])){
						if(segments1[i].start<=segments2[j].end){
							int index = segments1[i].index;
							segmentPoints[index] = k;
							i++;
							continue;
						}
					}

					if(k<m && points[k]<=segments2[j].end){
						k++;
						continue;
					}

					int index = segments2[j].index;
					int diff = k - segmentPoints[index];
					segmentPoints[index] = 0;
					if(diff%2!=0){
						total++;
					}
					j++;
				}
				System.out.println(total);
			}
		}

	}
}