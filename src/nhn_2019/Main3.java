package nhn_2019;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
5
K 2 A A A A A A
*/

class Main3 {
	public static int[][] map;
	public static boolean[] fol;
	public static int N;
	public static int pl[];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		map = new int[N][N];
		fol = new boolean[N];
		pl = new int[N];
		int number = 0;
		String com = sc.nextLine();
		String coms[] = com.split(" ");
		for(int i=0; i<coms.length; i++) {
			System.out.println(coms[i]);
			switch(coms[i]) {
			case "A":
				fol = new boolean[N];
				pl[i-number%N]++;
				solve(i-number%N);
				break;
			case "J":
				fol = new boolean[N];
				if(i-number%N==0) {
					pl[N-1]++;
					pl[i-number%N+1]++;
					solve(N-1);
					solve(i-number%N+1);
				}else if(i-number%N == N-1) {
					pl[0]++;
					pl[i-number%N-1]++;
					solve(0);
					solve(i-number%N-1);
				}else {
					pl[i-number%N+1]++;
					pl[i-number%N-1]++;
					solve(i-number%N+1);
					solve(i-number%N-1);
				}
				break;
			case "Q":
				for(int j=0; j<N; j++) {
					pl[j]++;
				}
				break;
			case "K":
				int follower = Integer.parseInt(coms[i+1]);
				map[i%N][follower]++;
				i++;
				number++;
				break;
			}
		}
		
		System.out.println(Arrays.toString(pl));
	}

	private static void solve(int i) {
		for(int j=0; j<N; j++) {
			if(map[i][j] > 0) {
				fol[j] = true;
				if(fol[j] == false) pl[j]++;
			}
		}
	}
}