package kakao_2021_blind;

import java.util.*;

public class Solution_03 {
	public static int[] solution(String[] info, String[] query) {
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0; i<query.length; i++) {
        	String temp[] = info;
        	for(int j=0; j<info.length; j++) {
        		temp[j] = info[j];
        	}
        	String[] q = query[i].replaceAll("and ", "").replaceAll("- ", "").split(" ");
        	for(int j=0; j<q.length-1; j++) temp = get0(temp,q[j]);
        	temp = get4(temp,q[q.length-1]);
        	
        	a.add(temp.length);
        }
        int[] answer = new int[a.size()];
        for(int i=0; i<a.size(); i++) {
        	answer[i] = a.get(i);
        }
        return answer;
    }
	
	public static String[] get0(String[] info, String lang) {
		ArrayList<String> a = new ArrayList<String>();
		
		for(int i=0; i<info.length; i++) {
			if(info[i].contains(lang)) {
				a.add(info[i]);
			}
		}
		String[] ans = new String[a.size()];
		for(int i=0; i<a.size(); i++) {
			ans[i] = a.get(i);
		}
		return ans;
	}
	
	public static String[] get4(String[] info, String score) {
		ArrayList<String> a = new ArrayList<String>();
		for(int i=0; i<info.length; i++) {
			String[] temp = info[i].split(" ");
			if(Integer.parseInt(temp[4])>= Integer.parseInt(score)) a.add(info[i]);
		}
		String[] ans = new String[a.size()];
		for(int i=0; i<a.size(); i++) {
			ans[i] = a.get(i);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println("[정답] "+Arrays.toString(solution(info,query)));
	}

}
