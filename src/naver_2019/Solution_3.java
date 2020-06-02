package naver_2019;
import java.util.*; 
public class Solution_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int map[] = new int[151];
        for(int i= 0; i<N; i++) {
        	int start = sc.nextInt();
        	int end = sc.nextInt();
        	for(int j=start; j<end; j++) 
        		map[j]++;
        }
        Arrays.sort(map);
        System.out.println(map[150]);
    }
}

