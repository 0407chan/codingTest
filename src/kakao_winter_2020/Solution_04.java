package kakao_winter_2020;

import java.util.PriorityQueue;


public class Solution_04 {
	
	public static PriorityQueue<node> q;
	public static int di[] = {-1,1,0,0};
	public static int dj[] = {0,0,-1,1};
	public static boolean[][] visit;
	public static int N, ans;
	public static class node implements Comparable<node>{
		int i;
		int j;
		int xi;
		int xj;
		int cost;
		public int getXi() {
			return xi;
		}
		public void setXi(int xi) {
			this.xi = xi;
		}
		public int getXj() {
			return xj;
		}
		public void setXj(int xj) {
			this.xj = xj;
		}
		public node(int i, int j, int xi, int xj, int cost) {
			super();
			this.i = i;
			this.j = j;
			this.xi = xi;
			this.xj = xj;
			this.cost = cost;
		}
		public int getI() {
			return i;
		}
		public void setI(int i) {
			this.i = i;
		}
		public int getJ() {
			return j;
		}
		public void setJ(int j) {
			this.j = j;
		}
		public int getCost() {
			return cost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}
		@Override
		public int compareTo(node n) {
			if(getCost() > n.getCost()) return 1;
			else if(getCost() < n.getCost()) return -1;
			return 0;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[i=");
			builder.append(i);
			builder.append(", j=");
			builder.append(j);
			builder.append(", xi=");
			builder.append(xi);
			builder.append(", xj=");
			builder.append(xj);
			builder.append(", cost=");
			builder.append(cost);
			builder.append("]");
			return builder.toString();
		}
		
		
	}
	public static int solution(int[][] map) {
		ans = 0;
		N = map.length;
		visit = new boolean[N][N];
		q = new PriorityQueue<>();
		visit[0][0] = true;
		q.offer(new node(0, 0, -1,-1, map[0][0]));
		
		bfs(map);
		
		System.out.println(ans);
        return ans;
    }
	
	private static void bfs(int[][] map) {
		while(!q.isEmpty()) {
			node curr = q.poll();
			for(int d= 0; d<4; ++d) {
				int ii = curr.getI() + di[d];
				int jj = curr.getJ() + dj[d];
				if(ii <0 || jj < 0|| ii >= N || jj >= N || visit[ii][jj] || map[ii][jj] == 1) continue;
				
				
				int cost = 100;
				//코너 체크하자
				if(!(curr.getXi() == -1 && curr.getXj() == -1)) {
					if(Math.abs(ii-curr.getXi()) == 1) {
						cost += 500;
					}
//					System.out.println((ii - curr.getXi())+" "+(jj - curr.getXj()));
//					System.out.println(Math.abs(ii-curr.getXi()));
				}
				
				if(ii == N-1 && jj == N-1) {
					ans = curr.getCost()+cost;
					return;
				}
				visit[ii][jj] = true;
				q.offer(new node(ii,jj,curr.getI(),curr.getJ(),curr.getCost()+cost));
				
			}
		}
	}
	
	public static void main(String[] args){
		int[][] s = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
		solution(s);
	}
}
