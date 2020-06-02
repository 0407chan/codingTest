package naver_2019;
import java.util.*;

public class Solution {
	
	public static int[] solution(int[][] data) {
		int len = data.length;
		int[] answer = new int[len];
		int idx = 0;
		boolean[] v = new boolean[len];
		int time = 0;
		
		while (idx < len) {
			List<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < len; i++) {
				if (v[i] || time < data[i][1])
					continue;
				
				list.add(i);
			}
			
			if (list.size() == 1) {
				int ii = list.get(0);
				v[ii] = true;
				answer[idx++] = ii + 1;
				time += data[ii][2] -1;
			}
			else if (list.size() > 1) {
				int res = list.get(0);
				
				for (int i = 1; i < list.size(); i++) {
					int ii = list.get(i);
					
					if (data[ii][2] < data[res][2]) {
						res = ii;
					}
					else if (data[ii][2] == data[res][2]) {
						if (data[ii][1] == data[res][1]) {
							if (data[ii][0] < data[res][0]) {
								res = ii;
							}
						}
						else {
							if (data[ii][1] < data[res][1]) {
								res = ii;
							}
						}
					}
				}
				
				v[res] = true;
				answer[idx++] = res + 1;
				time += data[res][2]-1;
			}
			
			++time;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[][] data = {{1, 2, 10},{2, 5, 8},{3, 6, 9},{4, 20, 6},{5, 25, 5}};
		int[][] data2 = {{1, 2, 5},{2, 1, 2},{3, 3, 1},{4, 4, 1},{5, 10, 2}};
		System.out.println(Arrays.toString(solution(data)));
		System.out.println(Arrays.toString(solution(data2)));
	}

}
