package line_2019;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class main1 {
	
	static class node implements Comparable<node>{
		int num;
		int cost;
		
		
		public node(int num, int cost) {
			super();
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(node a) {
			if(getCost() > a.getCost()) {
				return 1;
			}
			else if(getCost() < a.getCost()) {
				return -1;
			}
			else return 0;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/main1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int m = Integer.parseInt(s[0]);
		int c = Integer.parseInt(s[1]);
		int max = 0;
		
		PriorityQueue<node> q = new PriorityQueue<node>();
		
		for(int i=0; i<c; ++i) {
			q.offer(new node(i,0));
		}
		for(int i=0; i<m; ++i) {
			node curr = q.poll();
			int cost =Integer.parseInt(br.readLine());
			int newcost = curr.getCost()+ cost;
			max = Math.max(max, newcost);
			
			curr.setCost(newcost);
			q.offer(curr);
		}
		
		System.out.println(max);
	}
}
