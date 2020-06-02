package naver_2019;
import java.util.*;

public class Solution_1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int map[] = new int[b];
        for(int i=0; i<a; i++) {
        	map[0] += sc.nextInt();
        	Arrays.sort(map);
        }
        System.out.println(map[b-1]);
    }
}
