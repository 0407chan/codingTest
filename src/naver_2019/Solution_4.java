package naver_2019;
import java.util.*;
public class Solution_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int empty = 0;
        int max = 0;
        int s;
        for(int i=0; i<N;i++) {
        	s = sc.nextInt();
        	if(s == 0)
        		empty++;
        	else if(s == 1) {
        		max = Math.max(max, empty);
        		empty = 0;
        	}
        }
        
        System.out.println((max+1)/2);
    }
}

