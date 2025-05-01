package SWEA2070;

import java.util.Scanner;

public class SWEA2070 {

	public static void main(String[] args) {
		/*
		2개의 수를 입력 받아 크기를 비교하여 등호 또는 부등호를 출력하는 프로그램을 작성하라
		가장 첫 줄에는 테스트 케이스의 개수가 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		각 테스트 케이스의 첫번째 줄에는 2개의 수가 주어진다.
		출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
		*/
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 1; i <= T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			char result = swea(a, b);
			
//			if (a < b) {
//				result = '<';
//			} else if ( a == b) {
//				result = '=';
//			} else {
//				result = '>';
//			}
//			
			System.out.printf("#%d %c%n", i, result );
		}

	}
	
	public static char swea(int a, int b) {
		return (a<b) ? '<' : (a==b) ? '=' : '>';
	}

}
