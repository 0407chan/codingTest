package nTech_2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Solution4 {
	public static boolean solution(String input) {
        boolean answer = true;
        input = input.replaceAll("[0-9]", "").replaceAll("\\+", "").replaceAll("\\-", "").replaceAll("\\*", "").replaceAll("\\/", "");
        Stack<Character> s = new Stack<Character>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        ArrayList<Integer> max = new ArrayList<Integer>();
        map.put('[',3);
        map.put('{',2);
        map.put('(',1);
        map.put(']',6);
        map.put('}',5);
        map.put(')',4);
        if(input.charAt(0) == '}' || input.charAt(0) == ']' || input.charAt(0) == ')') {
        	return false;
        }
        
        for(int i=0 ; i<input.length(); i++) {
        	char temp = input.charAt(i);
    		if(temp == '[' || temp == '{' || temp == '(') {
    			if(max.size() == 0) {
    				s.push(temp);
    				max.add(map.get(temp));
    				continue;
    			}
    			if(map.get(temp) < max.get(max.size()-1)) {
    				s.push(temp);
    				max.add(map.get(temp));
    			}
    			else return false;
    		}
    		else if(temp ==']' || temp == '}' || temp == ')') {
    			if(map.get(s.peek()) == map.get(temp)-3) {
    				s.pop();
    				max.remove(max.size()-1);
    			}
    			else return false;
    		}
        }
        
        if(s.size() > 0) return false;
        return answer;
    }

	public static void main(String[] args) {
		String a = "3+[{(5+1)-(1+3)}+3]+(4+5) {";
		System.out.println(solution(a));
	}
}

