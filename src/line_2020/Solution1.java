package line_2020;
import java.util.*;

public class Solution1 {
	
    static public int solution(String s) {
        Stack<Character> s1 = new Stack<Character>();
        Stack<Character> s2 = new Stack<Character>();
        Stack<Character> s3 = new Stack<Character>();
        Stack<Character> s4 = new Stack<Character>();
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) == '[') {
        		s1.push('[');
        	}else if(s.charAt(i) ==']') {
        		if(s1.isEmpty()) return -1;
        		s1.pop();
        		cnt++;
        	}
        	
        	else if(s.charAt(i) =='{') {
        		s2.push('{');
        	}else if(s.charAt(i) =='}') {
        		if(s2.isEmpty()) return -1;
        		s2.pop();
        		cnt++;
        	}
        	
        	else if(s.charAt(i) =='(') {
        		s3.push('(');
        	}else if(s.charAt(i) ==')') {
        		if(s3.isEmpty()) return -1;
        		s3.pop();
        		cnt++;
        	}
        	
        	else if(s.charAt(i) =='<') {
        		s4.push('<');
        	}else if(s.charAt(i) =='>') {
        		if(s4.isEmpty()) return -1;
        		s4.pop();
        		cnt++;
        	}
        }
        if(s1.size()==0 && s2.size()==0 && s3.size()==0 && s4.size()==0) {
        	return cnt;
        }else {
        	return -1;
        }
    }
	
	
	public static void main(String[] args) {
		System.out.println(solution(">"));
	}
	
	
	
}
