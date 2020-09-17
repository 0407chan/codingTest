package kakao_2021_blind;

import java.util.*;

public class Solution_02 {
	public static String[] solution(String[] orders, int[] course) {
        
        Map<String, Integer> m = new HashMap<String, Integer>();
        ArrayList<String> list = new ArrayList<String>();
        Map<Integer,Integer> max = new HashMap<Integer, Integer>();
        for(int i=0; i<orders.length; i++) {
        	for(int j=i+1; j<orders.length; j++) {
        		String s1 = orders[i];
        		String s2 = orders[j];
        		StringBuilder sb = new StringBuilder();
        		
    			for(int k=0; k<s1.length(); k++) {
        			for(int l= 0; l< s2.length(); l++) {
        				if(s1.charAt(k)>s2.charAt(l)) continue;
        				if(s1.charAt(k)<s2.charAt(l)) continue;
        				if(s1.charAt(k)==s2.charAt(l)) sb.append(s1.charAt(k));
        			}
        		}
        		
        		char temp[] = sb.toString().toCharArray();
        		boolean[] visited = new boolean[temp.length];
        		Arrays.sort(temp);
        		
        		comb(temp,visited,0,temp.length, m);
        	}
        }
        for( String key : m.keySet() ){
        	for(int i=0; i<course.length; i++) {
        		if(key.length() == course[i]) {
        			if(max.get(key.length()) == null) max.put(key.length(), m.get(key));
            		else {
            			max.put(key.length(), Math.max(max.get(key.length()), m.get(key)));
            		}
        		}
        	}
        }
        
        for( String key : m.keySet() ){
    		if(m.get(key) == max.get(key.length())) {
    			list.add(key);
    		}
        }
        
        list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		String[] answer = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
	
	static void comb(char[] arr, boolean[] visited, int n, int end, Map<String, Integer> m) {
		if ( n >= end) {
			StringBuilder sb = new StringBuilder();
			for (int w = 0; w < end; w++) {
				if (visited[w]) sb.append(arr[w]);
			}
			
			String key = sb.toString();
			if(m.get(key) == null) m.put(key, 1);
    		else m.put(key, m.get(key)+1);
			
			return;
		}
	 
	    visited[n] = false;
	    comb(arr, visited, n+1, end, m);
	 
	    visited[n] = true;
	    comb(arr, visited, n+1, end,m);
	}
	
	public static void main(String[] args) {
		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = {2,3,5};
		System.out.println("[정답] "+Arrays.toString(solution(orders,course)));
	}

	
}
