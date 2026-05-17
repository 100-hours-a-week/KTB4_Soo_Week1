package org.example;

public class ObsessivePartner extends ExtrovertedPartner{
    private int jealousyLevel; // 질투 수치

    public ObsessivePartner(String name, Player player) {
        super(name, player);
        this.jealousyLevel = 0;
    }

    public int getJealousyLevel() {
        return jealousyLevel;
    }

    @Override
    public void introduce() {
        System.out.println("\n------------------------------------------------------");
        System.out.println("[상황] 화려한 바. " + getName() + " 님이 강렬한 눈빛을 빛내며 서 있습니다.");
        System.out.println("웃고 있지만 어딘가 모르게 소름 돋는 아우라가 풍깁니다.");
        System.out.println("------------------------------------------------------");
    }

    @Override
    public void respondStep1(int choice) {
        switch (choice) {
            case 1:
                System.out.println("\n[당신의 선택] \"오시는데 힘들진 않으셨어요?\"");
                System.out.println(getName() + ": \"아뇨? 전혀요? " + getPlayerName() + " 씨 만나러 오는 길인데 힘들 리가 없잖아요?\"");
                changeHeartRate(15);
                break;
            case 2:
                System.out.println("\n[당신의 선택] \"혹시 MBTI가 C.U.T.E 이신가요? ㅎㅎ\"");
                System.out.println(getName() + ": \"아하하하! 진짜 재밌으시다. 나 오직 " + getPlayerName() + " 씨만의 CUTE가 될래요.\"");
                changeHeartRate(25);
                changeTensionLevel(20);
                break;
        }
    }

    @Override
    public void respondStep2(int choice) {
        switch (choice) {
            case 1:
                System.out.println("\n[당신의 선택] 주말에는 보통 뭐 하세요?");
                System.out.println(getName() + ": \"전 " + getPlayerName() + " 씨 연락 기다리는 거 말고는 주말 계획 다 비워둘 건데요?\"");
                changeHeartRate(20);
                changeTensionLevel(10);
                break;
            case 2:
                System.out.println("\n[당신의 선택] 가방에서 슬쩍 고양이 키링 선물을 건넨다.");
                System.out.println(getName() + ": \"선물...? (갑자기 정색) 혹시 다른 사람한테도 이런 거 주면서 환장하게 만들고 다녀요? 누군지 말해봐요.\"");
                System.out.println("[시스템] 선물을 주자 뜬금없이 과도한 집착과 질투심이 폭발합니다!");
                changeHeartRate(-10);
                this.jealousyLevel += 40;
                break;
        }
    }

    @Override
    public void respondStep3(int choice) {
        switch (choice) {
            case 1:
                System.out.println("\n[당신의 선택] 마음에 드는데 우리 조만간 또 만날까요?");
                System.out.println(getName() + ": \"당연한 걸 왜 물어봐요? 우린 내일도 모레도 매일 만나야죠. 약속 지켜요?\"");
                changeHeartRate(25);
                break;
            case 2:
                System.out.println("\n[당신의 선택] 슬쩍 " + getName() + " 님의 손을 터치한다.");
                System.out.println(getName() + ": \"(손을 꽉 움켜쥐며 절대 안 놓아줌) 먼저 만진 거예요. 평생 못 놓아줘요.\"");
                changeHeartRate(35);
                changeTensionLevel(30);
                break;
        }
    }
}
