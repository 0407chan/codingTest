package kakao_2021_blind;

import java.util.Arrays;
import java.util.Map;

public class Solution_05 {
	public static String solution(String play_time, String adv_time, String[] logs) {
		if(play_time.equals(adv_time)) return "00:00:00";
        String answer = "";
        int video_length =timeToInt(play_time);
        int[] map = new int[video_length];
        
        for(int i=0; i<logs.length; i++) {
        	String temp[] = logs[i].split("-");
        	int start = timeToInt(temp[0]);
        	int end = timeToInt(temp[1]);
        	for(int j=start; j<end; j++) {
        		map[j]++;
        	}
        }
        int adv_len = timeToInt(adv_time);
        
        int max = 0;
        int curr =0;
        for(int i=0; i<adv_len; i++) {
        	max += map[i];
        	curr += map[i];
        }
        
        int best_start = 0;
        
        for(int i=0; i<video_length-adv_len; i++) {
        	curr = curr-map[i]+map[adv_len+i];
        	if(max < curr) {
        		max = curr;
        		best_start= i+1;
        	}
        }

        answer = intToTime(best_start);
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
	public static int timeToInt(String time) {
		int num = 0;
		String t[] = time.split(":");
		num += Integer.parseInt(t[0])*60*60 +Integer.parseInt(t[1])*60+Integer.parseInt(t[2]);
		return num;
	}
	
	public static String intToTime(int time_int) {
		String time = "";
		int min = 0;
		int sec = 0;
		
		sec = time_int % 60;
		time_int /= 60;
		min = time_int % 60;
		time_int /= 60;
		
		if(time_int < 10) time += "0"+time_int;
					 else time += time_int;
		
		if(min < 10) time += ":0"+min;
				else time += ":"+min;
		
		if(sec < 10) time += ":0"+sec;
				else time += ":"+sec;
		
		return time;
	}
	
	public static void main(String[] args) {
		String play_time = "00:00:06";
		String adv_time = "00:00:02";
		String[] logs = {"00:00:05-00:00:06","00:00:04-00:00:06","00:00:00-00:00:02"
				};
		System.out.println("[정답] "+solution(play_time,adv_time,logs));
	}

	
}
