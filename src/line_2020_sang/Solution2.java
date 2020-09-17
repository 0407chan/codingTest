package line_2020_sang;
public class Solution2 {
	
	static public int solution(String answer_sheet, String[] sh) {
        int ans = -1;
        for(int i=0; i<sh.length-1; ++i) {
        	for(int j=i+1; j<sh.length; ++j) {
        		int cnt = 0;
        		int con = 0;
        		int max = 0;
        		for(int k=0; k<answer_sheet.length(); ++k) {
        			if(sh[i].charAt(k) == sh[j].charAt(k)) {
        				if(sh[i].charAt(k) != answer_sheet.charAt(k)) {
        					//System.out.println("i="+i+" j="+j+" "+sh[i].charAt(k));
        					cnt++;
        					con++;
        				}else {
        					max = Math.max(max, con);
        					con = 0;
        				}
        			}
        			else {
    					max = Math.max(max, con);
    					con = 0;
    				}
        		}
        		max = Math.max(max, con);
        		//System.out.println(cnt+" "+max);
        		ans = Math.max(ans, cnt+max*max);
        	}
        }
        
        return ans;
    }
	
	public static void main(String[] args){
		System.out.println(solution("4132315142",new String[]{"3241523133","4121314445","3243523133","4433325251","2412313253"}));
	}
}
