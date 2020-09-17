package kakao_2021_blind;

import java.util.*;

public class Solution_03_new {
	public static int[] solution(String[] info, String[] query) {
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        Map<String, ArrayList<Integer>> m = new HashMap<String, ArrayList<Integer>>();
        for(int i=0; i<info.length; i++) {
        	String temp[] = info[i].split(" ");
        	boolean visit[] = new boolean[4];
        	comb(temp,visit,0,4, m);
        }
        
        for( String key : m.keySet() ){
    		Collections.sort(m.get(key));
        }
        
        System.out.println(m);
        
        for(int i=0; i<query.length; i++) {
        	String[] q = query[i].replaceAll("and ", "").replaceAll("- ", "").split(" ");
        	String key = "";
        	if(q.length > 1) {
	        	for(int j=0; j<q.length-1; j++) {
	        		key += q[j];
	        	}
        	}
        	int index = getIndex(m.get(key), Integer.parseInt(q[q.length-1]));
        	a.add(m.get(key).size()-index);
        	System.out.println(m.get(key)+" "+q[q.length-1]+" "+index);
        }
        
        int[] answer = new int[a.size()];
        for(int i=0; i<a.size(); i++) {
        	answer[i] = a.get(i);
        }
        return answer;
    }
	
	// 자기보다 큰거 나오는 인덱스 찾는 2진탐색
	static int getIndex(ArrayList<Integer> a, int value) {
		if(a.size() == 1) return 0;
		int start = 0;
		int end = a.size()-1;
		int mid = (start+end)/2;
		while(true) {
			if(start == end || start > end) break;
			if(a.get(mid) > value) {
				end = mid-1;
				mid = (start+end)/2;
			}else if(a.get(mid) < value){
				start = mid+1;
				mid = (start+end)/2;
			}else {
				end = mid;
				mid = (start+end)/2;
			}
		}
		return start;
	}
	
	// map에 모든 경우 집어넣는 조합
	static void comb(String[] arr, boolean[] visited, int n, int end, Map<String, ArrayList<Integer>> m) {
		if ( n >= end) {
			StringBuilder sb = new StringBuilder();
			for (int w = 0; w < end; w++) {
				if (visited[w]) sb.append(arr[w]);
			}
			
			String key = sb.toString();
			
			if(m.get(key) == null) {
        		ArrayList<Integer> value = new ArrayList<Integer>();
        		value.add(Integer.parseInt(arr[4]));
        		m.put(key,value);
        	}else {
        		ArrayList<Integer> value = m.get(key);
        		value.add(Integer.parseInt(arr[4]));
        		m.put(key,value);
        	}
			return;
		}
	 
	    visited[n] = false;
	    comb(arr, visited, n+1, end, m);
	 
	    visited[n] = true;
	    comb(arr, visited, n+1, end,m);
	}
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println("[정답] "+Arrays.toString(solution(info,query)));
	}

}
