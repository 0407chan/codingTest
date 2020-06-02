package nhn_2019;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Map<String, Integer> m = new HashMap<String, Integer>();
		int totalCard = 0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			String t = sc.next();
			if(m.get(t) == null) m.put(t,1);
			else {
				int num = m.get(t);
				m.put(t, num+1);
			}
		}
		
		int map[] = new int[m.size()];
		int index = 0;
		for( String key : m.keySet() ) {
			map[index++] = m.get(key);
			System.out.println( "key : " + key + ", value : " + m.get(key)) ;
		}
		
		int num[] = new int[1000];
		boolean check = false;
		boolean isPossible = true;
		for(int i=0; i<map.length; i++) {
			num[map[i]]++;
		}
		System.out.println(Arrays.toString(map));
		System.out.println(Arrays.toString(num));
		
		for(int i=0; i<num.length; i++) {
			if(num[i] >= 2) {
				if(check) isPossible = false;
				check = true;
			}
			
			if(i < num.length-1) {
				if(num[i] == 1 && num[i+1] >= 1) {
					if(check) isPossible = false;
					check = true;
					i++;
				}
			}
			
		}
		System.out.println(isPossible);
		System.out.println(m);
	}
}