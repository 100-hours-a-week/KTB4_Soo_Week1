package org.example.domain;

public class ExtrovertedPartner extends DatingPartner {
    private int tensionLevel; // 텐션 수치

    public ExtrovertedPartner(String name, Player player) {
        super(name, player);
        this.tensionLevel = 50;
    }

    public void changeTensionLevel(int amount) {
        this.tensionLevel += amount;
    }

    public int getTensionLevel() {
        return tensionLevel;
    }

    @Override
    public String respondStep1(int choice) {
        StringBuilder sb = new StringBuilder();
        switch (choice) {
            case 1:
                sb.append("\n[당신의 선택] \"오시는데 힘들진 않으셨어요?\"\n");
                sb.append(getName()).append(": \"아유 전혀요! 날씨가 좋아서 걸어오기 딱 좋던데요? ").append(getPlayerName()).append(" 씨는요?\"");

                changeHeartRate(15);
                changeTensionLevel(5);
                break;
            case 2:
                sb.append("\n[당신의 선택] \"혹시 MBTI가 C.U.T.E 이신가요? ㅎㅎ\"\n");
                sb.append(getName()).append(": \"아하하하! 뭐야 진짜 웃긴다 ㅋㅋㅋㅋ 저 그런 드립 완전 좋아해요!\"");

                changeHeartRate(25);
                changeTensionLevel(20);
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
                sb.append(getName()).append(": \"전 주말에 무조건 밖에 나가요! 핫플 카페 가거나 친구들이랑 한잔하는 거 좋아해요!\"");

                changeHeartRate(15);
                changeTensionLevel(10);
                break;
            case 2:
                sb.append("\n[당신의 선택] 가방에서 슬쩍 고양이 키링 선물을 건넨다.\n");
                sb.append(getName()).append(": \"헐 대박! 이거 요즘 구하기 진짜 힘든 핫템인데! 감동이에요 ㅠㅠ 가방에 바로 달아야지!\"");

                changeHeartRate(25);
                changeTensionLevel(15);
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
                sb.append(getName()).append(": \"좋죠! 이번 주 토요일 어때요? 저 힙한 맛집 아는데 거기로 예약할게요!\"");

                changeHeartRate(20);
                break;
            case 2:
                sb.append("\n[당신의 선택] 슬쩍 손을 터치한다.\n");
                sb.append(getName()).append(": \"(당황하지 않고 손을 마주 잡으며 따뜻하게 미소 지음) 와, 손 되게 따뜻하시네요? ㅎㅎ\"");

                changeHeartRate(30);
                changeTensionLevel(25);
                break;
        }
        return sb.toString();
    }
}
