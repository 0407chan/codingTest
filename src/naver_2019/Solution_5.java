package naver_2019;
import java.util.*;
public class Solution_5 {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int rx = sc.nextInt();
        int ry = sc.nextInt();
        long Combination[][] = new long[49][49];
        Combination[1][0] = 1;    
        Combination[1][1] = 1;
        for (int i = 2; i <= 48; i++){
            Combination[i][0] = 1;
            for (int j = 1; j <= 48; j++){
                Combination[i][j] = Combination[i - 1][j - 1] + Combination[i - 1][j];
             }
        }
        if(rx > x || rx < 0 || ry > y || ry < 0) System.out.println("fail");
        else if (rx == 0 && ry == 0) {
        	System.out.println(0);
        	System.out.println(1);
        }
        else {
        	System.out.println(rx+ry);
        	System.out.println(Combination[rx+ry][ry]);
        }
    }
}

