package line_2020_ha;

import java.util.*;

public class Solution3 {
	
	static Map<Integer,Integer> m;
	static int startN;
    static public int[] solution(int n) {
    	
    	
    	if(n < 10) {
    		return new int[] {0,n};
    	}
    	int[] answer = new int[2];
    	
    	m = new HashMap<Integer, Integer>();
    	m.put(n,0);
    	sol(n,0);
    	
    	int min = Integer.MAX_VALUE;
    	int key = 0;
    	System.out.println(m);
    	Iterator<Map.Entry<Integer, Integer>> entries = m.entrySet().iterator();
    	while (entries.hasNext()) {
    	    Map.Entry<Integer, Integer> entry = entries.next();
    	    if(min > entry.getValue()) {
    	    	min = entry.getValue();
    	    	key = entry.getKey();
    	    }
    	}
    	answer[0] = min;
    	answer[1] = key;
    	
        return answer;
    }
    
    private static void sol(int n, int count) {
    	startN = n;
    	if(m.size() == 0) return;
    	m.remove(n);
    	String s = n+"";
    	int[] map = new int[s.length()];
    	int val = n;
    	boolean[] visit = new boolean[map.length];
    	
    	int index = map.length-1;
    	while(true) {
    		if(val == 0) break;
    		map[index] = val%10;
    		index--;
    		val /= 10;
    	}
    	
    	comb(map,visit,0,map.length, count);
    	
    	
    	Iterator<Map.Entry<Integer, Integer>> entries = m.entrySet().iterator();
    	while (entries.hasNext()) {
    		if(m.size() == 1) break;
    	    Map.Entry<Integer, Integer> entry = entries.next();
    	    if(entry.getKey() < 10) continue;
        	sol(entry.getKey(), entry.getValue());
    	}
	}

	static void comb(int[] arr, boolean[] visited, int n, int end, int count) {
		if ( n >= end) {
			StringBuilder sb = new StringBuilder();
			for (int w = 0; w < end; w++) {
				sb.append(arr[w]);
				if (visited[w]) {
					if(w < visited.length-1)
						sb.append("+");
				}
			}
			
			String key = sb.toString();
			String keys[] = key.split("\\+");
			if(Integer.parseInt(keys[0]) == startN ) return;
			
			boolean check = true;
			for(int i=0; i<keys.length; i++) {
				if(keys[i].charAt(0) == '0') check = false;
			}
			if(check) {
				int ans = 0;
				int cnt = keys.length-1 + count;
				for(int i=0; i<keys.length; i++) {
					ans += Integer.parseInt(keys[i]);
				}
				
				if(m.get(ans) == null || m.get(ans) > cnt) {
					m.put(ans, cnt);
				}
			}
			return;
		}
	 
	    visited[n] = false;
	    comb(arr, visited, n+1, end, count);
	 
	    visited[n] = true;
	    comb(arr, visited, n+1, end, count);
	}
	
	public static void main(String[] args) {
		int n = 73425;
		System.out.println("[정답] "+Arrays.toString(solution(n)));
	}
	
	
	
}
