package line_2020_ha;

import java.util.ArrayList;

public class Solution5 {
	
	public static int solution(int[] cards) {
        int answer = -2;
        
        int p1 = 0;
        int p2 = 0;
        if(cards[0]>=10) {
        	p1 += 10;
        }else {
        	p1 = cards[0];
        }
        if(cards[2]>=10) {
        	p2 += 10;
        }else {
        	p1 = cards[1];
        }
        ArrayList<Integer> diler = new ArrayList<Integer>();
        if(cards[1]>=10) {
        	diler.add(10);
        }else {
        	diler.add(cards[1]);
        }
        
        int pTotal = p1+p2;
        int dTotal = cards[1];
        
        for(int i=3 ; i<cards.length; i++) {
        	
        }
        
        int cnt = 2;
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		int cards[] = {12, 7, 11, 6, 2, 12};
		System.out.println("[정답] "+solution(cards));
	}
	
	
	
}
