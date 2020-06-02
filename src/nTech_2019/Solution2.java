package nTech_2019;

public class Solution2 {
	public static int tcost;
	public static int solution(int a, int b , int c) {
        int ans = 0;
        int res = c / a;
        for(int i=0; i< res; i++) {
        	int temp = c - (a*i);
        	if(temp % b == 0) ans++;
        }
        return ans;
    }


	public static void main(String[] args) {
		int a = 1000;
		int b = 1000;
		int bud = 1000000;
		System.out.println(solution(a,b,bud));
	}
}

