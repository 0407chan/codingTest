package naver_2019;
public class Solution3 {
	
	public static int solution(String[] s) {
		int ans = 0;
        char[][] map = new char[s.length][s[0].length()];
        for(int i=0; i<s.length; i++) {
        	map[i] = s[i].toCharArray();
        }
        
        for(int i=0; i<map[0].length; i++) {
        	int ii= 0;
        	int jj= i;
        	int star =0;
        	boolean done = false;
        	boolean stuck = false;
        	while(true) {
        		switch(map[ii][jj]) {
        		case '#':
        			ii++;
        			break;
        		case '>':
        			jj++;
        			break;
        		case '<':
        			jj--;
        			break;
        		case '*':
        			if(star == 0){
        				ii++;
        				star++;
        			}else {
        				stuck = true;
        			}
        			break;
        		}
        		
        		if(stuck) break;
        		if(ii == map.length) {
        			done = true;
        			break;
        		}
        	}
        	if(stuck) continue;
        	if(done) ans++;
        }
        return ans;
    }
	public static void main(String[] args) {
		String[] s = {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
		System.out.println(solution(s));
	}
}

