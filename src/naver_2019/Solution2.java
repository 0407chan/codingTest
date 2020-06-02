package naver_2019;
public class Solution2 {
	
	public static int solution(String[] emails) {
        int answer = 0;
        boolean c1,c2,c3,c4,c5,c6;
        for(int i=0; i<emails.length; i++) {
        	c1 = true;
        	c2 = true;
        	c3 = true;
        	c4 = true;
        	c5 = true;
        	c6 = true;
        	// @ 거르기
        	for(int j=0; j<emails[i].length(); j++) {
        		String[] mail = emails[i].split("@");
        		if(mail.length != 2) {
        			c1 = false;
        			break;
        		}
        		
        		// 소문자 . 거르기
        		for(int k=0; k<mail[0].length(); k++) {
        			if( (mail[0].charAt(k) <= 'z' && mail[0].charAt(k) >= 'a') || mail[0].charAt(k) == '.' ) {
        				
        			}else {
        				c2 = false;
        				break;
        			}
        		}
        		
        		String s = mail[1];
        		if(!s.contains(".")) {
        			c3 = false;
        			break;
        		}
        		
        		String doma = s.replace('.', '@');
        		String[] dom = doma.split("@");
        		if(dom.length != 2) {
        			c4 = false;
        			break;
        		}
        		for(int k=0; k<dom[0].length(); k++) {
        			if( dom[0].charAt(k) <= 'z' && dom[0].charAt(k) >= 'a' ) {
        				
        			}else {
        				c5 = false;
        				break;
        			}
        		}
        		
    			if( dom[1].equals("com")||dom[1].equals("net")||dom[1].equals("org") ) {
    				
    			}else {
    				c6 = false;
    				break;
    			}
        	}
        	
        	if(c1 && c2 && c3 && c4&& c5&& c6) answer ++;
        }

        return answer;
    }
	public static void main(String[] args) {
		String[] emails = {"abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"};
		System.out.println(solution(emails));
	}
}

