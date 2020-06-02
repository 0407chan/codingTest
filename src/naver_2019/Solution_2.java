package naver_2019;
import java.util.*;

public class Solution_2 {
	public static int temp[];
	public static boolean[] visit;
	public static ArrayList<String> a;
	
	private static void solve(int start, int count, String str) {
		if(count >= 3) {
			a.add(str);
			return;
		}
		for(int i=start; i<3; i++) {
			if(visit[i] == true) continue;
			visit[i] = true;
			solve(0,count+1,str+temp[i]);
			visit[i] = false;
		}
	}
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
        int map[] = new int[3];
        for(int i=0; i<3; i++) {
        	map[i] = sc.nextInt();
        }
        a= new ArrayList<String>();
        
		temp = new int[3];
		visit = new boolean[3];
		for(int i=0; i<3; i++) {
			temp[i] = map[i];
		}
		Arrays.sort(temp);
		solve(0,0,"");
		Collections.sort(a);
		System.out.println(a.get(sc.nextInt()-1));
	}

	
}
