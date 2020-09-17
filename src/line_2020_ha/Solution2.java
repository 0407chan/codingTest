package line_2020_ha;

import java.util.*;

public class Solution2 {
	
    static public int[] solution(int[] ball, int[] order) {
        int[] answer = new int[ball.length];
        int ans_index = 0;
        
        int[] q = new int[ball.length];
        int q_len = 0;
        
        int start = 0;
        int end = ball.length-1;
        for(int i=0; i<order.length; i++) {
        	int curr = order[i];
        	int front = ball[start];
        	int back = ball[end];
        	
        	if(q_len > 0) {
        		int j=0;
        		while(true) {
        			if(q_len == 0 || j>=q_len) break;
        			int currQ = q[j];
        			if(currQ == ball[start]) {
        				start++;
        				answer[ans_index] = currQ;
                		ans_index++;
                		q[j] = 0;
                		j = 0;
        			}else if(currQ == ball[end]) {
        				end--;
        				answer[ans_index] = currQ;
                		ans_index++;
                		q[j] = 0;
                		j = 0;
        			}else {
        				j++;
        			}
        			q_len = resetQ(q);
        		}
        		q_len = resetQ(q);
        	}
        	
        	if(curr == front) {
        		start++;
        		answer[ans_index] = curr;
        		ans_index++;
        	}else if(curr == back) {
        		end--;
        		answer[ans_index] = curr;
        		ans_index++;
        	}else {
        		q[q_len] = curr;
        		q_len++;
        	}
        }
        
        if(q_len > 0) {
    		int j=0;
    		while(true) {
    			if(q_len == 0 || j>=q_len) break;
    			int currQ = q[j];
    			if(currQ == ball[start]) {
    				start++;
    				answer[ans_index] = currQ;
            		ans_index++;
            		q[j] = 0;
            		j = 0;
    			}else if(currQ == ball[end]) {
    				end--;
    				answer[ans_index] = currQ;
            		ans_index++;
            		q[j] = 0;
            		j = 0;
    			}else {
    				j++;
    			}
    			q_len = resetQ(q);
    		}
    		q_len = resetQ(q);
    	}
        
        return answer;
    }
	
	private static int resetQ(int[] q) {
		int curr = -1;
		int q_len = 0;
		for(int i=0; i<q.length; i++) {
			if(q[i]>0) q_len++;
		}
		for(int i=0; i<q.length; i++) {
			if(q[i]== 0 && curr == -1) {
				curr = i;
			}else if (q[i]> 0 && curr > -1){
				q[curr] = q[i];
				q[i] = 0;
				i = curr-1;
				curr = -1;
			}
		}
		return q_len;
	}

	public static void main(String[] args) {
		int ball[] = {11,2,9,13,24};
		int order[] = {9,2,13,24,11};
		System.out.println("[정답] "+Arrays.toString(solution(ball,order)));
	}
}
