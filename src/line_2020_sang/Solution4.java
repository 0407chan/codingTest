package line_2020_sang;
import java.util.*;

public class Solution4 {
	
	static public String[][] solution(String[][] snap, String[][] tran) {
		String[][] answer = {};
        ArrayList<String[]> a = new ArrayList<String[]>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<snap.length; ++i) {
        	map.put(snap[i][0],Integer.parseInt(snap[i][1]));
        }
        for(int i=0; i<a.size(); ++i) {
        	System.out.println(Arrays.toString(a.get(i)));
        }
        HashSet<String> set = new HashSet<String>();
        for(int i=0; i<tran.length; ++i) {
       		if(set.add(tran[i][0])) {
       			if(tran[i][1].equals("SAVE")) {
       				int account = 0;
       				if(map.containsKey(tran[i][2])) {
       					account = map.get(tran[i][2]);
       				}
       				map.put(tran[i][2], account + Integer.parseInt(tran[i][3]));
       			}else if(tran[i][1].equals("WITHDRAW")) {
       				int account = 0;
       				if(map.containsKey(tran[i][2])) {
       					account = map.get(tran[i][2]);
       				}
       				map.put(tran[i][2], account - Integer.parseInt(tran[i][3]));
       			}
       		}
        }
        answer = new String[map.size()][2];
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            String key = entry.getKey();

            Integer value = entry.getValue();

            a.add(new String[] {key, ""+value});
        }
        
        Collections.sort(a, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[0].compareTo(o2[0]);
			}
		});
        
        for(int i=0; i<a.size(); ++i) {
        	answer[i][0] = a.get(i)[0];
        	answer[i][1] = a.get(i)[1];
        }
        return answer;
    }
	public static void main(String[] args) {
		
		solution(new String[][]{{"ACCOUNT1", "100"}, {"ACCOUNT2", "150"}},
		new String[][]{{"1", "SAVE", "ACCOUNT2", "100"},
			  			{"2", "WITHDRAW", "ACCOUNT1", "50"}, 
			  			{"1", "SAVE", "ACCOUNT2", "100"}, 
			  			{"4", "SAVE", "ACCOUNT3", "500"}, 
			  			{"3", "WITHDRAW", "ACCOUNT2", "30"}});
	}
	
	
	
}
