package kakao_2021_blind;

public class Solution_01 {
	public static String solution(String new_id) {
		String answer = "";
		answer = new_id.toLowerCase();
		String match = "[^xfe0-9a-z\\s-_.]";
		answer = answer.replaceAll(match, "");
        answer = checkDot(answer);
        answer = removeFristDot(answer);
        answer = removeLastDot(answer);
        if(answer == "") {
        	answer = "a";
        }
        if(answer.length() >= 16) {
        	answer = answer.substring(0, 15);
        }
        answer = removeLastDot(answer);
        if(answer.length() <=2) {
        	String temp = "";
        	for(int i=0; i<3-answer.length(); i++) {
        		temp += answer.charAt(answer.length()-1);
        	}
        	answer += temp;
        }
		return answer;
	}
	public static String removeLastDot(String s) {
		if(s.length() > 1 && s.charAt(s.length()-1)=='.') {
        	s = s.substring(0, s.length()-1);
        }else if(s.length() == 1 && s.charAt(0)== '.'){
        	s = "";
        }
		return s;
	}
	public static String removeFristDot(String s) {
		if(s.length() > 1 && s.charAt(0)== '.') {
        	s = s.substring(1);
        }else if(s.length() == 1 && s.charAt(0)== '.'){
        	s = "";
        }
		return s;
	}
	
	public static String checkDot(String s) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<s.length()-1; i++) {
			if(s.charAt(i)== '.' && s.charAt(i+1) =='.') {
				continue;
			}
			sb.append(s.charAt(i));
		}
		sb.append(s.charAt(s.length()-1));
		return sb.toString();
	}
	
	public static void main(String[] args) {
//		String new_id = "\"...!@BaT#*..y.abcdefgh.ijklm\".............";
		String new_id = "abcdefghijklmn.p";
		solution(new_id);
	}

	
}
