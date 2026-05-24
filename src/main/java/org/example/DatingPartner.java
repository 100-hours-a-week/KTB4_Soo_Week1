package org.example;

public class DatingPartner {
    private String name;
    private int heartRate;  // 호감도
    private Player player;

    public DatingPartner(String name, Player player) {
        this.name = name;
        this.heartRate = 50;
        this.player = player;
    }

    // 공유자원 - 여러 스레드가 동시에 점수를 고칠 때 데이터가 깨지는 것을 막음
    public synchronized void changeHeartRate(int amount) {
        this.heartRate += amount;
    }

    public String getName() {
        return name;
    }

    // synchronized를 붙여 호감도를 안전하게 조회
    public synchronized int getHeartRate() {
        return heartRate;
    }

    public String getPlayerName(){
        return player.getName();
    }

    public void introduce() {
        System.out.println(name + ": 안녕하세요! 처음 뵙겠습니다. ㅎㅎ");
    }

    public void respondStep1(int choice) {}
    public void respondStep2(int choice) {}
    public void respondStep3(int choice) {}
}


