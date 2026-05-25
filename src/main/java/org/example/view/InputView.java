package org.example.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static String readLine() { return scanner.next(); }
    public static int readInt() {
        while (true) {
            String input = scanner.next();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ 올바른 숫자가 아닙니다. 1~4 숫자를 다시 입력해주세요.");
                System.out.print("당신의 선택은? : ");
            }
        }
    }
    public static int readIntWithRange(int min, int max) {
        while (true) {
            int number = readInt();

            // 가져온 숫자가 지정한 범위(min 이상 max 이하) 안의 값인지 체크
            if (number >= min && number <= max) {
                return number;
            }

            System.out.printf("⚠️ %d부터 %d 사이의 숫자만 입력해주세요.\n", min, max);
            System.out.print("당신의 선택은? : ");
        }
    }
}
