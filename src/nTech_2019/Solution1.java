package nTech_2019;

import java.util.*;

public class Solution1 {
	public static int tcost;
	public static int solution(long a) {
        int ans = 0;
        long temp = a;
        long res = a;
        HashSet<Long> set = new HashSet<Long>();
        while(true) {
        	if(res == 0) break;
        	long num = res % 10;
        	if(num == 0) {
        		res /= 10;
        		continue;
        	}
        	if(temp % num == 0)
        		if(set.add(num))
        			ans++;
        	res /= 10;
        }
        return ans;
    }


	public static void main(String[] args) {
		long a = 122231;
		System.out.println(solution(a));
	}
}

