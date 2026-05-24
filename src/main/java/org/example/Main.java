package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatingPartner partner = null;

//        // 타이머 테스트 코드가
//        System.out.println("=== 1단계: 타이머 스레드 단독 테스트 시작 ===");
//        TimerRunnable timerRunnable = new TimerRunnable();
//        Thread timerThread = new Thread(timerRunnable);
//        timerThread.start();

        System.out.println("======================================================");
        System.out.println("  ☕ 눈치코치 소개팅 시뮬레이션 ☕");
        System.out.println("======================================================");

        System.out.print("당신의 이름을 입력해 주세요: ");
        String playerName = scanner.next();
        Player player = new Player(playerName);
        System.out.println();

        System.out.println("--- 소개팅 상대 선택 ---");
        System.out.println("1. 김민지(외향형)");
        System.out.println("2. 윤서아(내향형)");
        System.out.println("3. 이지수(극 내향형)");
        System.out.println("4. 이지아(집착형)");
        System.out.println();

        System.out.print("소개팅 상대를 선택하세요 (1~4) : ");
        int characterChoice = scanner.nextInt();

        switch (characterChoice) {
            case 1:
                partner = new ExtrovertedPartner("김민지", player);
                break;
            case 2:
                partner = new IntrovertedPartner("윤서아", player);
                break;
            case 3:
                partner = new ExtremelyShyPartner("이지수", player);
                break;
            case 4:
                partner = new ObsessivePartner("이지아", player);
                break;
            default:
                System.out.println("올바른 번호가 아닙니다. 이지수 님으로 강제 시작합니다.");
                partner = new ExtremelyShyPartner("이지수", player);
                break;
        }

        partner.introduce();

        // 비동기 테스트 코드
        System.out.println("\n=== [멀티스레드 합동 테스트] 타이머와 스탯 스레드를 가동합니다 ===");

        // 타이머 스레드 가동
        Thread timerThread = new Thread(new TimerRunnable());
        timerThread.start();

        // 스탯 변동 스레드
        Thread statThread = new Thread(new StartBurnRunnable(partner));
        statThread.start();

        // 1단계 대화: 첫인사
        System.out.println("\n💬 [1단계: 첫인사 나누기]");
        System.out.println("1. 무난하게 대화 열기: \"오시는데 힘들진 않으셨어요?\"");
        System.out.println("2. 무리수 개그 던지기: \"혹시 MBTI가 C.U.T.E 이신가요? ㅎㅎ\"");
        System.out.print("당신의 선택은? (1~2) : ");
        partner.respondStep1(scanner.nextInt());
        System.out.println("[현재 호감도: " + partner.getHeartRate() + "점]");

        // 2단계 대화: 깊은 대화
        System.out.println("\n💬 [2단계: 분위기가 조금 가라앉았을 때, 당신의 행동은?]");
        System.out.println("1. 질문 공세: \"주말에는 보통 뭐 하세요?\"");
        System.out.println("2. 준비성 어필: 가방에서 슬쩍 고양이 키링 선물을 건넨다.");
        System.out.print("당신의 선택은? (1~2) : ");
        partner.respondStep2(scanner.nextInt());
        System.out.println("[현재 호감도: " + partner.getHeartRate() + "점]");

        // 3단계 대화: 승부수
        System.out.println("\n💬 [3단계: 헤어지기 직전, 마지막 타이밍!]");
        System.out.println("1. 돌직구 고백: \"마음에 드는데 우리 조만간 또 만날까요?\"");
        System.out.println("2. 스킨십 시도: 슬쩍 " + partner.getName() + " 님의 손을 터치한다.");
        System.out.print("당신의 선택은? (1~2) : ");
        partner.respondStep3(scanner.nextInt());

        // 최종 엔딩
        System.out.println("\n======================================================");
        System.out.println("⏱️ 카페 이용 시간이 끝나 소개팅이 마무리되었습니다.");
        System.out.println("최종 결산 ➔ [" + partner.getName() + " 님의 최종 호감도: " + partner.getHeartRate() + "점]");
        System.out.println("======================================================");

        if (partner.getHeartRate() >= 75) {
            System.out.println("🎉 [HAPPY ENDING] 소개팅 대성공! 당당하게 애프터를 얻어내고 주말 약속을 잡았습니다!");
        } else if (partner.getHeartRate() >= 50) {
            System.out.println("😐 [NORMAL ENDING] 미지근한 엔딩... 연락은 이어지지만 언제 끊길지 모르는 애매한 사이가 되었습니다.");
        } else {
            System.out.println("😭 [BAD ENDING] 소개팅 대폭망! 상대방은 급한 일이 생겼다며 도망치듯 떠났고, 주선자에게 카톡으로 차였습니다.");
        }
    }
}