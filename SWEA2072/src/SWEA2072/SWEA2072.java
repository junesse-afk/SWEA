package SWEA2072;

import java.util.Scanner;

public class SWEA2072 {

	public static void main(String[] args) {
		/*
		10개의 수를 입력 받아 그 중에서 홀수만 더한 값을 출력하는 프로그램을 작성하라
		가장 첫 줄에는 테스트 케이스의 개수가 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		각 테스트 케이스의 첫번째 줄에는 10개의 수가 주어진다.
		출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
		*/
		
		final int COUNT = 10;
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 1; i <= T; i++) {
			int sum = 0;
			
			for (int y = 0; y < COUNT; y++) {
				int num = sc.nextInt();
				if (num % 2 == 1) {
					sum += num;
				}
			}
			
			System.out.printf("#%d %d%n", i, sum);
		}

	}

}
