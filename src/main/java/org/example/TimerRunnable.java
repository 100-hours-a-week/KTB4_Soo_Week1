package org.example;

public class TimerRunnable implements Runnable{
    @Override
    public void run(){
        try{
            for(int i = 10; i > 0; i--){
                System.out.println("   ⏳ (" + i + "초 남음...)");
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
                System.out.println("유저가 입력하여 타이머를 종료합니다.");
        }
    }
}
