package line_2020;
import java.util.*;
import java.util.Arrays;

public class Solution3 {
	
	static public int solution(String r, int n) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        int cnt = 1;
        for(int i=0; i<r.length()-1; ++i) {
        	if(r.charAt(i) == r.charAt(i+1)) {
        		cnt++;
        	}else {
        		a.add(cnt);
        		cnt = 1;
        	}
        }
        a.add(cnt);
        int newN = n;
        int index= 0;
        int max = 0;
        int tans = 0;
        ArrayList<Integer> b = new ArrayList<Integer>(a);
        System.out.println(b);
        for(int i=0; i<b.size()/2; ++i) {
        	if(b.get(i*2+1) <= newN) {
        		int t = b.get(i*2+1);
        		newN -= t;
        		b.set(i*2+1, 0);
        		tans += b.get(i*2)+t;
        	}
        	else{
        		tans += b.get(i*2);
        		max = Math.max(max, tans);
        		tans = 0;
        		b = new ArrayList<Integer>(a);
        		newN = n;
        		
        		i = index;
        		index++;
        	}
        }
        tans += b.get(b.size() -1);
		max = Math.max(max, tans);
		tans = 0;
		
        //System.out.println(max);
        return max;
    }
	
	public static void main(String[] args)  {
		solution("111011110011111011111100011111",6);
		
	}
}
