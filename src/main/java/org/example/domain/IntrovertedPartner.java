package org.example.domain;

public class IntrovertedPartner extends DatingPartner {
    private int energyLevel; // 기력

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
    public String respondStep1(int choice) {
        StringBuilder sb = new StringBuilder();
        switch (choice) {
            case 1:
                sb.append("\n[당신의 선택] \"오시는데 힘들진 않으셨어요?\"\n");
                sb.append(getName()).append(": \"아, 네... 친절하게 물어봐 주셔서 감사합니다. 오는데 편했어요.\"");

                changeHeartRate(15);
                changeEnergyLevel(-5);
                break;
            case 2:
                sb.append("\n[당신의 선택] \"혹시 MBTI가 C.U.T.E 이신가요? ㅎㅎ\"\n");
                sb.append(getName()).append(": \"네? 아... 제 MBTI는 ISFJ인데... 귀엽다고 해주신 건가요? (어색)\"");

                changeHeartRate(0);
                changeEnergyLevel(-15);
                break;
        }
        return sb.toString();
    }

    @Override
    public String respondStep2(int choice) {
        StringBuilder sb = new StringBuilder();
        switch (choice) {
            case 1:
                sb.append("\n[당신의 선택] 주말에는 보통 뭐 하세요?\n");
                sb.append(getName()).append(": \"저는 그냥 조용히 집에서 책 보거나 밀린 예능 프로그램 봐요...\"");

                changeHeartRate(15);
                changeEnergyLevel(-5);
                break;
            case 2:
                sb.append("\n[당신의 선택] 가방에서 슬쩍 고양이 키링 선물을 건넨다.\n");
                sb.append(getName()).append(": \"앗, 귀엽네요! 생각지도 못한 선물이라 좀 놀랐지만 감사해요. ㅎㅎ\"");

                changeHeartRate(20);
                changeEnergyLevel(5);
                break;
        }
        return sb.toString();
    }

    @Override
    public String respondStep3(int choice) {
        StringBuilder sb = new StringBuilder();
        switch (choice) {
            case 1:
                sb.append("\n[당신의 선택] 마음에 드는데 우리 조만간 또 만날까요?\n");
                sb.append(getName()).append(": \"아... 네! 저도 오늘 나름 긴장 풀고 즐거웠어요. 주말에 시간 맞춰봐요!\"");

                changeHeartRate(20);
                break;
            case 2:
                sb.append("\n[당신의 선택] 슬쩍 손을 터치한다.\n");
                sb.append(getName()).append(": \"(조금 굳어지며 손을 무릎 위로 올린다) 아... 죄송해요, 제가 속도가 좀 느려서...\"");

                changeHeartRate(-20);
                changeEnergyLevel(-25);
                break;
        }
        return sb.toString();
    }

}
