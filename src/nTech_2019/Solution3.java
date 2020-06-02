package nTech_2019;

public class Solution3 {


	public static int solution(int n, int k) {



		int[][] comb = new int[32][33];
		comb[0][0] = 1;
		comb[0][1] = 1;
		for(int i = 1; i < 32; i++) {
			comb[i][0] = 1;
			for(int j = 1; j <= i + 1; j++) {
				comb[i][j] = comb[i-1][j] + comb[i-1][j-1];
				comb[i][j] %= 10007;
			}
		}

		int answer = 1;
		for(int i=n; i>n-k; i--) {
			answer *= i;
			answer %= 10007;
		}

		long a = comb[n][k]%10007;
		answer = (int) (answer * a);
		if(k > n) answer = 0;
		else {
			answer *= comb[n-1][k];
			answer %= 10007;
		}

		return answer;
	}

	public static void main(String[] args) {
		int n = 3;
		int k = 2;
		System.out.println(solution(n,k));
	}
}

