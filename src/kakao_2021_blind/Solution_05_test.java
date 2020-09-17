package kakao_2021_blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_05_test {
	public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int video_length =timeToInt(play_time);
        int[] map = new int[video_length];
        
        ArrayList<int[]> a = new ArrayList<int[]>();
        
        for(int i=0; i<logs.length; i++) {
        	int start = timeToInt(logs[i].split("-")[0]);
        	int end = timeToInt(logs[i].split("-")[1]);
        	a.add(new int[] {start,end});
        }
        System.out.println(a);
        a.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]-o2[0] == 0) {
					return o1[1]-o2[1];
				}else
					return o1[0]-o2[0];
			}
		});
        
        for (int[] is : a) {
			System.out.println(Arrays.toString(is));
		}
        
        int adv_len = timeToInt(adv_time);
        
        
        
        int max = 0;
        int curr =0;
        int curr_start = 0;
        int curr_end = curr_start+adv_len;
        for (int[] is : a) {
			System.out.println(Arrays.toString(is));
			if(curr_end <= is[0] || curr_start >= is[1]) continue;
			// is[0] 부터 curr_end까지
			else if(curr_start < is[0] && is[0] < curr_end) {
				curr = curr_end - is[0];
			}
			// start부터 end까지
			else if(curr_start >= is[0] && is[0] < curr_end) {
				curr = curr_end - curr_start;
			}
			// start부터 is[1]까지
			else if(curr_start >= is[0] && curr_end <= is[1]) {
				curr = is[1] - curr_start;
			}
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
	
	public static int timeToInt(String time) {
		int num = 0;
		String t[] = time.split(":");
		num += Integer.parseInt(t[0])*60*60;
		num += Integer.parseInt(t[1])*60;
		num += Integer.parseInt(t[2]);
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
		if(time_int < 10) {
			time += "0"+time_int;
		}else {
			time += time_int;
		}
		if(min < 10) {
			time += ":0"+min;
		}else {
			time += ":"+min;
		}
		if(sec < 10) {
			time += ":0"+sec;
		}else {
			time += ":"+sec;
		}
		return time;
	}
	
	public static void main(String[] args) {
		String play_time = "00:00:10";
		String adv_time = "00:00:05";
		String[] logs = {"00:00:00-00:00:09", 
				"00:00:01-00:00:08", 
				"00:00:02-00:00:07", 
				"00:00:03-00:00:06"};
//		String play_time = "99:59:59";
//		String adv_time = "25:00:00";
//		String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
		System.out.println("[정답] "+solution(play_time,adv_time,logs));
	}

	
}
