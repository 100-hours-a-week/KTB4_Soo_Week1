package org.example;

public class IntrovertedPartner extends DatingPartner{
    public int energyLevel; // 기력

    public IntrovertedPartner(String name, Player player) {
        super(name, player);
        this.energyLevel = 100;
    }

    public void changeEnergyLevel(int amount) {
        this.energyLevel += amount;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    @Override
    public void respondStep1(int choice) {
        switch (choice) {
            case 1:
                System.out.println("\n[당신의 선택] \"오시는데 힘들진 않으셨어요?\"");
                System.out.println(getName() + ": \"아, 네... 친절하게 물어봐 주셔서 감사합니다. 오는데 편했어요.\"");
                changeHeartRate(15);
                changeEnergyLevel(-5);
                break;
            case 2:
                System.out.println("\n[당신의 선택] \"혹시 MBTI가 C.U.T.E 이신가요? ㅎㅎ\"");
                System.out.println(getName() + ": \"네? 아... 제 MBTI는 ISFJ인데... 귀엽다고 해주신 건가요? (어색)\"");
                changeHeartRate(0);
                changeEnergyLevel(-15);
                break;
        }
    }

    @Override
    public void respondStep2(int choice) {
        switch (choice) {
            case 1:
                System.out.println("\n[당신의 선택] 주말에는 보통 뭐 하세요?");
                System.out.println(getName() + ": \"저는 그냥 조용히 집에서 책 보거나 밀린 예능 프로그램 봐요...\"");
                changeHeartRate(15);
                changeEnergyLevel(-5);
                break;
            case 2:
                System.out.println("\n[당신의 선택] 가방에서 슬쩍 고양이 키링 선물을 건넨다.");
                System.out.println(getName() + ": \"앗, 귀엽네요! 생각지도 못한 선물이라 좀 놀랐지만 감사해요. ㅎㅎ\"");
                changeHeartRate(20);
                changeEnergyLevel(5);
                break;
        }
    }

    @Override
    public void respondStep3(int choice) {
        switch (choice) {
            case 1:
                System.out.println("\n[당신의 선택] 마음에 드는데 우리 조만간 또 만날까요?");
                System.out.println(getName() + ": \"아... 네! 저도 오늘 나름 긴장 풀고 즐거웠어요. 주말에 시간 맞춰봐요!\"");
                changeHeartRate(20);
                break;
            case 2:
                System.out.println("\n[당신의 선택] 슬쩍 손을 터치한다.");
                System.out.println(getName() + ": \"(조금 굳어지며 손을 무릎 위로 올린다) 아... 죄송해요, 제가 속도가 좀 느려서...\"");
                changeHeartRate(-20);
                changeEnergyLevel(-25);
                break;
        }
    }

}
