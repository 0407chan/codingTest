package line_2019;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class main2 {
	static String[] permlist;
	static ArrayList<String> a;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/main2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		permlist = br.readLine().split(" ");
		a = new ArrayList<String>();
		permute(0,permlist.length-1);
		Collections.sort(a);
		System.out.println(a.get(Integer.parseInt(br.readLine())-1));
	}
	
	private static void permute(int l, int r) 
    { 
        if (l == r) { 
        	String temp = "";
        	for(int i=0; i<permlist.length; ++i) {
        		temp+= permlist[i];
        	}
        	a.add(temp);
        }
        else { 
            for (int i = l; i <= r; i++) { 
                swap(l, i); 
                permute(l + 1, r); 
                swap(l, i); 
            } 
        } 
    }
	
	private static void swap(int l, int i) {
		String temp = permlist[i];
		permlist[i] = permlist[l];
		permlist[l] = temp;
	}
}
