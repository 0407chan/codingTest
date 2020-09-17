package line_2020_ha;

import java.util.*;

public class Solution1 {
	
    static public int solution(int[][] boxes) {
        int answer = -1;
        Map<Long, Long> m = new HashMap<Long, Long>();
        int num_box = boxes.length;
        for(int i=0; i<num_box; i++) {
        	long long1 = boxes[i][0];
        	long long2 = boxes[i][1];
        	if(m.get(long1) == null) {
        		m.put(long1, (long) 1);
        	}else {
        		m.put(long1, m.get(long1)+1);
        	}
        	if(m.get(long2) == null) {
        		m.put(long2, (long) 1);
        	}else {
        		m.put(long2, m.get(long2)+1);
        	}
        }
        
        System.out.println(m);
        int cnt = 0;
        int res = 0;
        for( long key : m.keySet() ){
        	long val = m.get(key);
        	cnt += val/2;
        	if(val%2 == 1) res += val%2;
        }
        answer = num_box-cnt;
        System.out.println(num_box+"-"+cnt+"="+answer+" "+res);
        if(answer <= res) {
        	return answer;
        }else {
        	return res;
        }
    }
	
	
	public static void main(String[] args) {
//		int boxes[][] = {{1,2},{2,1},{3,3},{4,5},{5,6},{7,8}};
		int boxes[][] = {{1,2},{2,3},{3,1}};
		System.out.println("[정답] "+solution(boxes));
	}
	
	
	
}
