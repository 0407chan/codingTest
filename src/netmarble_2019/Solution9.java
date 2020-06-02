package netmarble_2019;
import java.util.*;

public class Solution9 {
	public static int[][] timeMap, mileMap;
	public static ArrayList<int[]> ans = new ArrayList<int[]>();
	public static int minTime;
	private static int[] solution(int n, int k, int[][] paths) {
		timeMap = new int[n+1][n+1];
		mileMap = new int[n+1][n+1];
		minTime = Integer.MAX_VALUE;
		boolean[][] visit = new boolean[n+1][n+1];
		for(int i=0; i<paths.length; i++) {
			timeMap[paths[i][0]][paths[i][1]] = paths[i][2];
			timeMap[paths[i][1]][paths[i][0]] = paths[i][2];
			mileMap[paths[i][0]][paths[i][1]] = paths[i][3];
			mileMap[paths[i][1]][paths[i][0]] = paths[i][3];
		}
		
		solve(k,n,1,0,0,visit);
		
		Collections.sort(ans, new Comparator<int[]>() {
			@Override
			public int compare(int[] a0, int[] a1) {
				if(a0[0] == a1[0]) return a1[1] - a0[1];
				else return a0[0] - a1[0];
			}
		});
		
		return ans.get(0);
	}
	
	private static void solve(int k, int n, int curr, int time, int mile, boolean[][] visit) {
		if(curr == k) {
			ans.add(new int[] {time,mile});
			if(minTime > time) minTime = time;
			return;
		}
		if(time > minTime) return;
		
		boolean[][] temp = new boolean[n+1][n+1];
		
		for(int i=0; i<n+1; i++) 
			for(int j=0; j<n+1; j++) 
				temp[i][j] = visit[i][j];
		
		for(int i=1 ; i<n+1; i++) {
			if(timeMap[curr][i] == 0) continue;
			if(temp[curr][i] || temp[i][curr]) continue;
			temp[curr][i] = true;
			temp[i][curr] = true;
			solve(k,n,i,time+timeMap[curr][i],mile+mileMap[curr][i], temp);
		}
	}

	public static void main(String[] args) {
		int n = 5;
		int k = 4;
		int[][] paths = {{1,5,1,1},{1,2,4,3},{1,3,3,2},
						{2,5,2,1},{2,4,2,3},{3,4,2,2}};
		System.out.println(Arrays.toString(solution(n,k,paths)));
	}
}