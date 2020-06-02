package line_2019;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class main4 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/main4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine().replaceAll(" ","");
		boolean isStart = false;
		boolean isEnd = false;
		if(s.charAt(0) == '0') isStart = true;
		if(s.charAt(N-1) == '0') isEnd = true;
		int cnt = 0;
		int max = 0;
		for(int i=1; i<N; ++i) {
			cnt++;
			
			if(s.charAt(i) == '1') {
				if(isStart) {
					max = Math.max(max, cnt);
					isStart = false;
				}
				else max = Math.max(max, cnt/2);
				cnt = 0;
			}
		}
		
		if(isEnd) max = Math.max(max, cnt);
		System.out.println(max);
	}
}
