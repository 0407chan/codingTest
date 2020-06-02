package line_2019;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class main3 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/main3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t[] = new int[151];
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; ++i) {
			String s[] = br.readLine().split(" ");
			int st = Integer.parseInt(s[0]);
			int e = Integer.parseInt(s[1]);
			
			for(int j= st; j<e; ++j) {
				t[j] ++;
			}
		}
		
		int max = 0;
		for(int i=0; i<= 150; ++i) {
			max = Math.max(max, t[i]);
		}
		System.out.println(max);
	}
	
}
