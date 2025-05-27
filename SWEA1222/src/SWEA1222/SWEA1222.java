package SWEA1222;

import java.util.Scanner;
import java.util.Stack;

public class SWEA1222 {

	public static void main(String[] args) {
		/*문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.
		 *예를 들어 “3+4+5+6+7” 라는 문자열로 된 계산식을 후위 표기식으로 바꾸면 다음과 같다.
		 *"34+5+6+7+" 변환된 식을 계산하면 25를 얻을 수 있다.
		 *문자열 계산식을 구성하는 연산자는 + 하나뿐이며 피연산자인 숫자는 0 ~ 9의 정수만 주어진다.
		*/
		
        Scanner sc = new Scanner(System.in);
        
        for(int t = 1; t<=10; t++) {
            String input = sc.next();
            
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            
            //입력한 데이터 중 숫자는 바로 붙이고
            for(int i = 0; i<input.length(); i++) {
            	char ch =input.charAt(i);
            	if(Character.isDigit(ch)) {
            		sb.append(ch);
            		
            	// 연산자를 스택에 넣음
            	} else if(ch == '+') {
            		while(!stack.isEmpty()) {
            			sb.append(stack.pop());
            		}
            		stack.push(ch);
            	}
            }
            
            while(!stack.isEmpty()) {
            	sb.append(stack.pop());
            }
            
            //후의 표기식 계산
            Stack<Integer> calc = new Stack<>();
            
            for(int i = 0; i<sb.length(); i++) {
            	char ch = sb.charAt(i);
            	if(Character.isDigit(ch)) {
            		calc.push(ch-'0');
            	} else if (ch == '+') {
            		int b = calc.pop();
            		int a = calc.pop();
            		calc.push(a+b);
            	}
            }
            
            System.out.println("결과" + calc.pop());

        }

	}

}
