package SWEA1223;

import java.util.Scanner;
import java.util.Stack;

public class SWEA1223 {

    public static void main(String[] args) {
        /*
         * 문자열로 이루어진 계산식이 주어질때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.
         * 
         * 예를들어
         * 3+4+5*6+7 라는 문자열로 된 계산식을 후위 표기식으로 바꾸면 다음과 같다.
         * 34+56*+7+ 변환된 식을 계산하면 44를 얻을 수 있다.
         * 문자열 계산식을 구성하는 연산자는 +,* 두 종류이며 피연산자인 숫자는 0~9의 정수만 주어진다.
         * 
         * [출력]
         * #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 답을 출력한다
         * 
         * */
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // 버퍼에서 남은 줄 바꿈 문자 비우기
        
        for (int i = 1; i <= T; i++) {
            String a = sc.nextLine(); // 계산식 입력
            String b = change(a); // 후위 표기식으로 변환
            int result = rechange(b); // 후위 표기식을 계산
            
            System.out.println("#" + i + " " + result); // 결과 출력
        }
        
        sc.close();
    }
    
    // 연산자 우선순위 설정
    static int rangking(char op) {
        if (op == '*') return 2; // 곱셈은 더 높은 우선순위
        if (op == '+') return 1; // 덧셈은 낮은 우선순위
        return 0;
    }

    // 중위 표기식을 후위 표기식으로 변환
    static String change(String fix) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (char ch : fix.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch); // 숫자는 바로 출력
            } else if (ch == '+' || ch == '*') {
                // 연산자가 스택에 있을 경우 우선순위 비교 후 출력
                while (!stack.isEmpty() && rangking(stack.peek()) >= rangking(ch)) {
                    sb.append(stack.pop());
                }
                stack.push(ch); // 현재 연산자 스택에 넣기
            }
        }
        
        // 스택에 남은 연산자 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }

    // 후위 표기식을 계산
    static int rechange(String refix) {
        Stack<Integer> stack = new Stack<>();
        
        for (char ch : refix.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // 숫자는 스택에 넣음
            } else {
                int b = stack.pop(); // 오른쪽 피연산자
                int a = stack.pop(); // 왼쪽 피연산자
                int result = 0;
                if (ch == '+') result = a + b; // 덧셈
                else if (ch == '*') result = a * b; // 곱셈
                stack.push(result); // 계산 결과 다시 스택에 넣기
            }
        }
        
        return stack.pop(); // 최종 계산된 값 반환
    }
}
