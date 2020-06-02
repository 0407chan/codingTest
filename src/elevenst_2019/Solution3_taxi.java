package elevenst_2019;
import java.util.*;

public class Solution3_taxi {
	public static int solution(int n, int[] a) {
		int ans = 0;
		int curr = a[0];
		for(int i=0; i<n; i++) {
			if(curr < a[i]) {
				ans += curr;
			}else {
				curr = a[i];
				ans += a[i];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int n = 10;
		int a[] = {5,7,8,2,4,6,1,8,9,10};
		System.out.println(solution(n,a));
	}
}
