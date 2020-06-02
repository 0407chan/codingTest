package elevenst_2019;
import java.util.Arrays;

public class Solution2 {

	
	
	
	public static int[] solution(int N) {
		int max = 0;
		int jinbub = 0;
		for(int i=2; i<10; i++) {
			int res = 1;
			int n = N;

			while(true){
				if(n == 0) break;
				if(n%i != 0)
					res *= n%i;
				n = n/i;
			}

			if( max <= res) {
				max = res;
				jinbub = i;
			}
		}
		return new int[] {jinbub,max};
	}

	public static void main(String[] args) {
		int a = 1000000;
		System.out.println(Arrays.toString(solution(a)));
	}
}
