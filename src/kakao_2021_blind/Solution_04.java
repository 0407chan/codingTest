package kakao_2021_blind;

import java.util.Arrays;

public class Solution_04 {
	public static int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n][n];
        for (int[] is : map) {
        	Arrays.fill(is, Integer.MAX_VALUE);
		}
        
        for(int i=0; i<fares.length; i++) {
        	int ii= fares[i][0]-1;
        	int jj= fares[i][1]-1;
        	int cost = fares[i][2];
        	map[ii][jj] = cost;
        	map[jj][ii] = cost;
        }
        
        for(int i=0; i<n; i++) {
        	map[i][i] = 0;
        }
        for(int k=0; k<map.length; k++) {
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map.length; j++) {
					if(map[i][k] + map[k][j] < map[i][j]) map[i][j] = map[i][k]+map[k][j];
				}
			}
		}
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
        	if(i == s-1) {
        		min = Math.min(min, map[i][a-1] + map[i][b-1]);
        	}else if (i== a-1) {
        		min = Math.min(min, map[i][s-1] + map[i][b-1]);
        	}else if (i== b-1) {
        		min = Math.min(min, map[i][a-1] + map[i][s-1]);
        	}else {
        		min = Math.min(min, map[i][s-1] + map[i][a-1] + map[i][b-1]); 
        	}
        }
        return min;
	}
	
	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = {{4, 1, 10}, {3, 5, 24},{5, 6, 2},{3, 1, 41},{5, 1, 24},{4, 6, 50},{2, 4, 66},{2, 3, 22},{1, 6, 25}};
		System.out.println("[정답] "+solution(n,s,a,b,fares));
	}
}
