package org.example;

public class StartBurnRunnable implements Runnable{
    private final DatingPartner partner;

    public StartBurnRunnable(DatingPartner partner){
        this.partner = partner;
    }

    @Override
    public void run(){
        try{
            // 메인 스레드가 중지 신호를 보내기 전까지 무한 반복하며 스탯을 깎는다.
            while(!Thread.currentThread().isInterrupted()){
                Thread.sleep(3000);
                partner.changeHeartRate(-3);

                System.out.println("\n🚨 [실시간 패널티] 침묵이 길어져 "
                        + partner.getName() + " 님의 호감도가 3 감소했습니다! (현재 호감도: "
                        + partner.getHeartRate() + "점)");
                System.out.print("당신의 선택은? : ");
            }
        }catch (InterruptedException e){
            System.out.println("\n유저가 입력하여 스탯 변동 스레드를 종료합니다.");
        }
    }

}
