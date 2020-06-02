package kakao_winter_2020;

public class Solution_4번 {
	
	public static int di[] = {-1,1,0,0};
	public static int dj[] = {0,0,-1,1};
	public static boolean[][] visit;
	public static int N, ans;
	public static int dp[][];
	
	public static int solution(int[][] map) {
		ans = Integer.MAX_VALUE;
		N = map.length;
		dp = new int[N][N];
		for(int i=0; i<N; ++i) {
			for( int j=0; j<N; ++j) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		visit = new boolean[N][N];
		dp[0][0] = 0;
		visit[0][0] = true;
		
		dfs(map,0,0,-1,-1,0);
		
		System.out.println(ans);
        return ans;
    }
	
	private static void dfs(int[][] map, int i,int j, int xi, int xj, int cost) {
		for(int d= 0; d<4; ++d) {
			int ii = i + di[d];
			int jj = j + dj[d];
			if(ii <0 || jj < 0|| ii >= N || jj >= N || visit[ii][jj] || map[ii][jj] == 1) continue;
			int newCost = 100;
			//코너 체크하자
			if(!(xi == -1 && xj == -1)) {
				if(Math.abs(ii-xi) == 1) {
					newCost += 500;
				}
			}
			
			if(dp[ii][jj] < cost+newCost) continue;
			
			if(ii == N-1 && jj == N-1) {
				dp[ii][jj] = Math.min(dp[ii][jj], cost+newCost);
				ans = Math.min(ans, cost+newCost);
				return;
			}
			visit[ii][jj] = true;
			dp[ii][jj] = Math.min(dp[ii][jj], cost+newCost);
			dfs(map,ii,jj,i,j,cost+newCost);
			visit[ii][jj] = false;
		}
	}
	
	public static void main(String[] args){
		int[][] s = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
		solution(s);
	}
}
