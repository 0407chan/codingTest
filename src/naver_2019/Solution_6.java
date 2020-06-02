package naver_2019;
import java.util.*;
public class Solution_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sort = sc.next();
        int len = 0;
        int max = 0;
        ArrayList<int[]> a = new ArrayList<int[]>();
        ArrayList<ArrayList<String>> ps = new ArrayList<>();
        ArrayList<String> pattern = new ArrayList<>();
        for(int i=0 ; i<N; i++) {
        	int size = sc.nextInt();
        	max = Math.max(max, size);
        	String num = sc.next();
        	String nums[] = num.split("");
        	for(int j=0; j<nums.length; j++) {
        		len += size;
        		a.add(new int[] {size,Integer.parseInt(nums[j])});
        	}
        }
        
        pattern.add("..#");
        pattern.add("..#");
        pattern.add("..#");
        pattern.add("..#");
        pattern.add("..#");
        ps.add(pattern);
        pattern = new ArrayList<>();
        pattern.add("###");
        pattern.add("..#");
        pattern.add("###");
        pattern.add("#..");
        pattern.add("###");
        ps.add(pattern);
        pattern = new ArrayList<>();
        pattern.add("###");
        pattern.add("..#");
        pattern.add("###");
        pattern.add("..#");
        pattern.add("###");
        ps.add(pattern);
        pattern = new ArrayList<>();
        pattern.add("#.#");
        pattern.add("#.#");
        pattern.add("###");
        pattern.add("..#");
        pattern.add("..#");
        ps.add(pattern);
        pattern = new ArrayList<>();
        pattern.add("###");
        pattern.add("#..");
        pattern.add("###");
        pattern.add("..#");
        pattern.add("###");
        ps.add(pattern);
        pattern = new ArrayList<>();
        pattern.add("#..");
        pattern.add("#..");
        pattern.add("###");
        pattern.add("#.#");
        pattern.add("###");
        ps.add(pattern);
        pattern = new ArrayList<>();
        pattern.add("###");
        pattern.add("..#");
        pattern.add("..#");
        pattern.add("..#");
        pattern.add("..#");
        ps.add(pattern);
        pattern = new ArrayList<>();
        pattern.add("###");
        pattern.add("#.#");
        pattern.add("###");
        pattern.add("#.#");
        pattern.add("###");
        ps.add(pattern);
        pattern = new ArrayList<>();
        pattern.add("###");
        pattern.add("#.#");
        pattern.add("###");
        pattern.add("..#");
        pattern.add("###");
        ps.add(pattern);
        pattern = new ArrayList<>();
        pattern.add("###");
        pattern.add("#.#");
        pattern.add("#.#");
        pattern.add("#.#");
        pattern.add("###");
        ps.add(pattern);
        
        for(int i=0; i<max*2; i++) {
        	
        	for(int j=0; j<a.size(); j++) {
        		//최대크기일때
        		if(a.get(j)[0] == max) {
        			String line = "";
        			if(i == 0 || i == max*2-1 || i == max) {
        				line = ps.get(a.get(j)[1]).get(i/2);
        			}if(i < max && i > 0){
        				line = ps.get(a.get(j)[1]).get(1);
        			}else if(i > max && i < max*2) {
        				line = ps.get(a.get(j)[1]).get(3);
        			}
        			System.out.print(getLine(line,max));
        		}
        		//작은 크기일때
        		else {
        		}
    			System.out.print(" ");
        	}
        	System.out.println();
        }
        
    }

	private static String getLine(String line,int len) {
		StringBuilder s = new StringBuilder();
		
		switch(line) {
		case "###":
			for(int i=0; i<len; i++) {
				s.append("#");
			}
			break;
		case "#..":
			s.append("#");
			for(int i=0; i<len-1; i++) {
				s.append(".");
			}
			break;
		case "..#":
			for(int i=0; i<len-1; i++) {
				s.append(".");
			}
			s.append("#");
			break;
		case "#.#":
			s.append("#");
			for(int i=0; i<len-2; i++) {
				s.append(".");
			}
			s.append("#");
			break;
		}
		
		return s.toString();
	}
}