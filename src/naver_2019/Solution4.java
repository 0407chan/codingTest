package naver_2019;
import java.util.*;

public class Solution4 {
	
	public static int[] solution(int[][] data) {
		int[] ans = new int[data.length];
		int ansIndex = 0;
		ArrayList<int[]> a = new ArrayList<int[]>();
		ArrayList<int[]> w = new ArrayList<int[]>();
		for(int i=0 ;i<data.length; i++) {
			a.add(new int[]{data[i][0],data[i][1],data[i][2]});
		}
		
		Collections.sort(a, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		int index = 0;
		int count = 0;
		int curr[] = null;
		while(true) {
			if(data.length == ansIndex) break;
			
			// 일단 w에 저장
			if(a.size()> 0 && count == a.get(index)[1]) {
				w.add(a.get(0));
				a.remove(0);
			}
			Collections.sort(w, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[2] == o2[2]) {
						return o1[1]-o2[1];
					}
					else {
						return o1[2]-o2[2];
					}
				}
			});
			if(curr == null && w.size()>0) {
				curr = w.get(0);
				w.remove(0);
			}
			
			if(curr != null) curr[2]--;
			count++;
			if(curr != null && curr[2]== 0) {
				ans[ansIndex] = curr[0];
				ansIndex++;
				curr = null;
			}
		}
        return ans;
    }
	public static void main(String[] args) {
		int[][] data = {{1, 2, 10},{2, 5, 8},{3, 6, 9},{4, 20, 6},{5, 25, 5}};
		int[][] data2 = {{2, 2, 2},{1, 0, 5},{3, 3, 1},{4, 4, 1},{5, 10, 2}};
		System.out.println(Arrays.toString(solution(data)));
	}
}

