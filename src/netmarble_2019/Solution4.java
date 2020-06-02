package netmarble_2019;
import java.util.*;

public class Solution4 {
	public static boolean[] visit;
	private static int solution(int k, int[] a) {
		visit = new boolean[a.length];
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for(int i=0; i<a.length-1; i++) {
			int temp = a[i]-a[i+1];
			if(m.get(temp) == null) {
				m.put(temp, 1);
			}else {
				m.put(temp, m.get(temp)+1);
			}
		}
		for( Integer key : m.keySet() ){
			if(m.get(key) >= k) {
				deleteItem(a,key);
			}
        }
		
		int ans = 0;
		for(int i=0 ;i<visit.length; i++) {
			if(visit[i]==false) ans++;
		}
		return ans;
	}
	
	private static void deleteItem(int[] a, Integer key) {
		for(int i=0; i<a.length-1; i++) {
			int temp = a[i]-a[i+1];
			if(temp == key) {
				visit[i] = true;
				visit[i+1] = true;
			}
		}
	}

	public static void main(String[] args) {
		int k = 3;
		int[] a = {24,22,20,10,5,3,2,1};
		int k2 = 2;
		int[] a2 = {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100};
		System.out.println(solution(k2,a2));
	}

}
