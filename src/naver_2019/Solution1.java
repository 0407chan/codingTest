package naver_2019;
import java.util.regex.Pattern;

public class Solution1 {
	
	public static int solution(String[] emails) {
        int ans = 0;
        String pattern1 = "^[a-z.]+@[a-z]+\\.(org|net|com)$";
        for(int i=0; i<emails.length; i++)
        	if(Pattern.matches(pattern1, emails[i])) ans++;
        return ans;
    }
	
	
	
	public static void main(String[] args) {
		String[] emails = {".@.@.com","asdf@naver.org","a@a.com","a@a.a.com"};
		System.out.println(solution(emails));
	}
}

