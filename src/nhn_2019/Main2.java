package nhn_2019;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Main2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num[] = new int[101];
		int N = sc.nextInt();
		int max = 0;
		int curr = 0;
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			String com = sc.next();
			if(com.equals("enqueue")) {
				int n = sc.nextInt();
				num[n]++;
				if(max < num[n]) {
					max = num[n];
					curr = n;
				}
				a.add(n);
			}else if(com.equals("dequeue")) {
				
			}
		}
		System.out.println(curr);
		System.out.println(Arrays.toString(num));
		System.out.println(a);
	}
}