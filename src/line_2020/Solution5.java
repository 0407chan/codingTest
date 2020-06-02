package line_2020;
import java.util.*;

public class Solution5 {
	
	static class node {
		String name;
		int cost;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCost() {
			return cost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}
		public node(String name, int cost) {
			super();
			this.name = name;
			this.cost = cost;
		}
	}
	static public String[] solution(String[][] data, String[] tags) {
        String[] answer = {};
        List<String> taglist = Arrays.asList(tags);
        Collections.sort(taglist);
        ArrayList<node> a = new ArrayList<node>();
        for(int i=0; i< data.length; ++i) {
        	a.add(new node(data[i][0],0));
        	for(int j=1 ; j<data[i].length; ++j) {
        		node t = a.get(i);
        		if(taglist.contains(data[i][j])) {
        			t.setCost(t.getCost() + 1);
        			a.set(i, t);
        		}
        	}
        }
        Collections.sort(a, new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				if(o1.getCost() > o2.getCost()) return -1;
				else if(o1.getCost() < o2.getCost()) return 1;
				else {
					return o1.getName().compareTo(o2.getName());
				}
			}
		});
        
        ArrayList<String> ans = new ArrayList<String>();
        for(int i=0; i<a.size(); ++i) {
        	if(a.get(i).getCost() >0) { 
        		ans.add(a.get(i).getName());     
        	}
        	if(i > 10) break;
        }
        
        answer = new String[ans.size()];
        for(int i=0; i<ans.size(); ++i) {
        	answer[i] = ans.get(i);
        }
        
        return answer;
    }
	public static void main(String[] args)  {
		solution(new String[][] {
			{"doc1", "t1", "t2", "t3"},
		    {"doc2", "t0", "t2", "t3"},
		    {"doc3", "t1", "t6", "t7"},
		    {"doc4", "t1", "t2", "t4"},
		    {"doc5", "t6", "t100", "t8"}
			},
			new String[]{"t1", "t2", "t3"}
			);
	}
	
	
	
}
