import java.util.Scanner;

public class SWEA15941 {
    /* 정수 N이 주어질 때, 모든 변의 길이가 N인 가장 넓은 평행사변형의 넓이를 출력하라라 */

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            int ex = sc.nextInt();
            System.out.println("#" + test_case + " " + (ex * ex));

		}
         sc.close();
    }

}
