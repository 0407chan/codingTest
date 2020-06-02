package elevenst_2019;
public class Solution1 {
	public static int ans;
	public static int[] d;
	
	public static int solution(int[] a) {
		ans = 0;
		d = new int[a.length];
		for(int i=0 ; i<a.length; i++) 
			d[i] = a[i];
		
		perm(d.length-1,0);
		return ans;
	}
	
	public static void swap(int i, int k) {
		int temp = d[i] ;
		d[i] = d[k];
		d[k] = temp;
	}
	
	private static void perm(int n, int k) {
		if(k==n) {
			int res = 0;
			for(int i=0 ; i<d.length-1; i++)
				res += Math.abs(d[i]-d[i+1]);
			ans = Math.max(ans, res);
		}else {
			for(int i=k; i<=n; i++) {
				swap(i,k);
				perm(n,k+1);
				swap(i,k);
			}
		}
	}

	public static void main(String[] args) {
		int a[] = {20,8,10,1,4,15};
		System.out.println(solution(a));
	}
}
