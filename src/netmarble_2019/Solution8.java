package netmarble_2019;
import java.util.*;
public class Solution8 {
	public static int[] di = {-1,-1,0,1,1, 1, 0,-1};
	public static int[] dj = { 0, 1,1,1,0,-1,-1,-1};
	public static int N,M,isChanged;
	private static String[] solution(String[] s) {
		String[][] ss = new String[2][];
		isChanged = 0;
		N = 2;
		M = s[0].length();
		for(int i=0 ; i<2; i++) ss[i] = s[i].split("");
		
		while(true) {
			if(isChanged > 2*s[0].length() + 5) break;
			for(int i=0; i<2; i++) {
				for(int j=0; j<s[0].length(); j++) {
					if(!ss[i][j].equals(".") && !ss[i][j].equals("M") && !ss[i][j].equals("S"))
						check(i,j,ss);
				}
			}
			isChanged++;
		}
		StringBuilder sb = new StringBuilder();
		String[] ans = new String[2];
		for(int i=0; i<2; i++) {
			for(int j=0; j<ss[0].length; j++) {
				if(ss[i][j].equals(".")) sb.append("?");
				else sb.append(ss[i][j]);
			}
			ans[i] = sb.toString();
			sb = new StringBuilder();
		}
		//System.out.println(Arrays.toString(ans));
		return ans;
	}

	private static void check(int i, int j, String[][] ss) {
		ArrayList<int[]> dots = new ArrayList<int[]>();
		int mine = 0;
		int S = 0;
		for(int d= 0; d<8; d++) {
			int ii = i + di[d];
			int jj = j + dj[d];
			if(ii >= N || ii < 0 || jj >= M || jj <0 ) continue;
			
			if(ss[ii][jj].equals(".")) dots.add(new int[] {ii,jj});
			else if(ss[ii][jj].equals("M")) mine++;
			else if(ss[ii][jj].equals("S")) S++;
		}
		
		if(Integer.parseInt(ss[i][j]) == dots.size()) {
			if(mine > 0 && dots.size() - mine - S == 0) setDot(ss,dots,"S");
			else setDot(ss,dots,"M");
		}else if(Integer.parseInt(ss[i][j]) == 0) setDot(ss,dots,"S");
	}

	private static void setDot(String[][] ss, ArrayList<int[]> dots, String state) {
		for(int i=0; i<dots.size(); i++) {
			if(ss[dots.get(i)[0]][dots.get(i)[1]].equals(".")) {
				ss[dots.get(i)[0]][dots.get(i)[1]] = state;
				isChanged = 0;
			}
		}
	}

	public static void main(String[] args) {
		String s[] = {".1...2",
					  "111.3."};
		String s2[] = {".3....", "1..20."};
		System.out.println(solution(s2));
	}
}