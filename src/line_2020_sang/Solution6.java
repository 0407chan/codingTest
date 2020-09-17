package line_2020_sang;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Solution6 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/sol6.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solution(new int[][] {{0,1},{1,0}});
	}
	
	static public int[] solution(int[][] v) {
	    int[] answer = {};
	
	    System.out.println("Hello Java");
	
	    return answer;
	}
	
}
