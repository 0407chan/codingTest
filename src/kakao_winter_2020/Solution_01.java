package kakao_winter_2020;

import java.io.FileNotFoundException;

public class Solution_01 {
	public static String solution(int[] nums, String hand) {
		StringBuilder sb = new StringBuilder();
		
		int map[][] = {{0,4,3,4,3,2,3,2,1,2,1,1}, // 0
				
						{4,0,1,2,1,2,3,2,3,4,3,5},// 1
						{3,1,0,1,2,1,2,3,4,3,4,4},// 2
						{4,2,1,0,3,2,1,4,3,2,5,3},// 3
						
						{3,1,2,3,0,1,2,1,2,3,2,4},// 4
						{2,2,1,2,1,0,1,2,1,2,3,3},// 5
						{3,3,2,1,2,1,0,3,2,1,4,2},// 6
						
						{2,2,3,4,1,2,3,0,1,2,1,3},// 7
						{1,3,2,3,2,1,2,1,0,1,2,2},// 8
						{2,4,3,2,3,2,1,2,1,0,3,1},// 9
						
						{1,3,4,5,2,3,4,1,2,3,0,2},// * 10
						{1,5,4,3,4,3,2,3,2,1,2,0},// # 11
		};
		
		int currLeft = 10;
		int currRight = 11;
		
		// [현재][갈곳];
		for(int i=0; i<nums.length; ++i) {
			switch(nums[i]) {
				case 1:
					sb.append("L");
					currLeft = 1;
					break;
				case 4:
					sb.append("L");
					currLeft = 4;
					break;
				case 7:
					sb.append("L");
					currLeft = 7;
					break;
					
				case 3:
					sb.append("R");
					currRight = 3;
					break;
				case 6:
					sb.append("R");
					currRight = 6;
					break;
				case 9:
					sb.append("R");
					currRight = 9;
					break;
					
				case 2:
					if(map[currLeft][2] > map[currRight][2]) {
						sb.append("R");
						currRight = 2;
					}else if(map[currLeft][2] < map[currRight][2]) {
						sb.append("L");
						currLeft = 2;
					}else {
						if(hand.equals("right")) {
							sb.append("R");
							currRight = 2;
						}else if(hand.equals("left")) {
							sb.append("L");
							currLeft = 2;
						}
					}
					break;
				case 5:
					if(map[currLeft][5] > map[currRight][5]) {
						sb.append("R");
						currRight = 5;
					}else if(map[currLeft][5] < map[currRight][5]) {
						sb.append("L");
						currLeft = 5;
					}else {
						if(hand.equals("right")) {
							sb.append("R");
							currRight = 5;
						}else if(hand.equals("left")) {
							sb.append("L");
							currLeft = 5;
						}
					}
					break;
				case 8:
					if(map[currLeft][8] > map[currRight][8]) {
						sb.append("R");
						currRight = 8;
					}else if(map[currLeft][8] < map[currRight][8]) {
						sb.append("L");
						currLeft = 8;
					}else {
						if(hand.equals("right")) {
							sb.append("R");
							currRight = 8;
						}else if(hand.equals("left")) {
							sb.append("L");
							currLeft = 8;
						}
					}
					break;
				case 0:
					if(map[currLeft][0] > map[currRight][0]) {
						sb.append("R");
						currRight = 0;
					}else if(map[currLeft][0] < map[currRight][0]) {
						sb.append("L");
						currLeft = 0;
					}else {
						if(hand.equals("right")) {
							sb.append("R");
							currRight = 0;
						}else if(hand.equals("left")) {
							sb.append("L");
							currLeft = 0;
						}
					}
					break;
				}
		}
        return sb.toString();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
//		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//		String hand = "right";
		
		int[] numbers = {1,9,5};
		String hand = "left";
		solution(numbers, hand);
	}

	
}
