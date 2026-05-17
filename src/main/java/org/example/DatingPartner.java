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

    public void changeHeartRate(int amount) {
        this.heartRate += amount;
    }

    public String getName() {
        return name;
    }

    public int getHeartRate() {
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


