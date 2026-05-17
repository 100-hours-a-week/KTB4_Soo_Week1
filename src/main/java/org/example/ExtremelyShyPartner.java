package org.example;

public class ExtremelyShyPartner extends IntrovertedPartner{
    private boolean isEyeContactFailed; // 낯가림

    public ExtremelyShyPartner(String name, Player player) {
        super(name, player);
        this.isEyeContactFailed = true;
    }

    public boolean isEyeContactFailed() {
        return isEyeContactFailed;
    }

    @Override
    public void introduce() {
        System.out.println("\n------------------------------------------------------");
        System.out.println("[상황] 조용한 카페. " + getName() + " 님이 들어옵니다.");
        System.out.println("귀까지 빨개진 채 바닥만 보며 겨우 자리에 앉았습니다.");
        System.out.println("------------------------------------------------------");
    }

    @Override
    public void respondStep1(int choice) {
        switch (choice) {
            case 1:
                System.out.println("\n[당신의 선택] \"오시는데 힘들진 않으셨어요?\"");
                System.out.println(getName() + ": \"아... 네... 조금 막히긴 했는데 괜찮았어요...ㅎㅎ\"");
                changeHeartRate(10);
                changeEnergyLevel(-5);
                break;
            case 2:
                System.out.println("\n[당신의 선택] \"혹시 MBTI가 C.U.T.E 이신가요? ㅎㅎ\"");
                System.out.println(getName() + ": \"(얼굴 폭발) 어... 네? 아... 그게 무슨...\"");
                System.out.println("[시스템] 너무 당황한 나머지 손을 떨다 빨대를 떨어뜨렸습니다!");
                changeHeartRate(-15);
                changeEnergyLevel(-20);
                break;
        }
    }

    @Override
    public void respondStep2(int choice) {
        switch (choice) {
            case 1:
                System.out.println("\n[당신의 선택] 주말에는 보통 뭐 하세요?");
                System.out.println(getName() + ": \"저.. 저는 그냥 집에서 넷플릭스 보거나 고양이 유투브 봐요...\"");
                changeHeartRate(15);
                changeEnergyLevel(-5);
                break;
            case 2:
                System.out.println("\n[당신의 선택] 가방에서 슬쩍 고양이 키링 선물을 건넨다.");
                System.out.println(getName() + ": \"...아! 이거 제가 좋아하는 캐릭터인데! 고맙습니다... (베시시 미소)\"");
                System.out.println("[시스템] " + getName() + " 님이 마음의 문을 열고 눈을 마주치기 시작합니다!");
                changeHeartRate(30);
                this.isEyeContactFailed = false;
                break;
        }
    }

    @Override
    public void respondStep3(int choice) {
        switch (choice) {
            case 1:
                System.out.println("\n[당신의 선택] 마음에 드는데 우리 조만간 또 만날까요?");
                if (isEyeContactFailed) {
                    System.out.println(getName() + ": \"아... 저 성격이 좀 안 맞으실 거 같은데... (바닥을 보며 고개를 저음)\"");
                    changeHeartRate(-15);
                } else {
                    System.out.println(getName() + ": \"(수줍게 웃으며 " + getPlayerName() + " 씨를 바라봄) 네... 다음엔 제가 맛있는 곳 찾을게요...!\"");
                    changeHeartRate(25);
                }
                break;
            case 2:
                System.out.println("\n[당신의 선택] 슬쩍 " + getName() + " 님의 손을 터치한다.");
                System.out.println(getName() + ": \"앗...! (깜짝 놀라며 손을 황급히 뺍니다)\"");
                System.out.println("[시스템] 극내향인에게 섣부른 스킨십은 치명적인 독입니다!");
                changeHeartRate(-30);
                changeEnergyLevel(-30);
                break;
        }
    }
}
