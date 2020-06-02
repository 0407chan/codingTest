package netmarble_2019;
public class Solution6 {
	public static int N,M,ans;
	                       //우상,우,우하,하
	public static int[] di = {-1,0,1,1};
	public static int[] dj = {1 ,1,1,0};
							//좌하,좌,좌상,상
	public static int[] di2 = { 1, 0,-1,-1};
	public static int[] dj2 = {-1,-1,-1, 0};
	private static int solution(int h, int w, int n, String[] map) {
		N = h;
		M = w;
		ans = 0;
		for(int j=0 ; j<w; j++) {
			for(int i=0 ; i<h; i++) {
				if(map[i].charAt(j) == '1') check(map,i,j,n);
			}
		}
		return ans;
	}

	private static void check(String[] map, int i, int j, int n) {
		
		for(int d= 0; d<4; d++) {
			int ii = i;
			int jj = j;
			int count = 1;
			if(ii+di2[d] >= 0 && ii+di2[d] < N && jj+dj2[d] >= 0 && jj+dj2[d] < M) {
				if(map[ii+di2[d]].charAt(jj+dj2[d]) == '1') continue;
			}
			while(true) {
				ii = ii + di[d];
				jj = jj + dj[d];
				if(ii >= N || ii < 0 || jj >= M || jj < 0) break;
				
				if(map[ii].charAt(jj) == '1') count++;
				else break;
			}
			
			if(count == n) {
				ans++;
				count = 1;
			}
		}
	}

	public static void main(String[] args) {
		int h = 7;
		int w = 9;
		int n = 4;
		String[] map = {"111100000",
						"000010011",
						"111100011",
						"111110011",
						"111100011",
						"111100010",
						"111100000",};
		
		int h2 = 5;
		int w2 = 5;
		int n2 = 5;
		String[] map2 = {"11111",
						"11111",
						"11111",
						"11111",
						"11111"};
		System.out.println(solution(h2,w2,n2,map2));
	}
}
