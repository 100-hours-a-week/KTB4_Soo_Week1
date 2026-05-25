package org.example.runnable;

public class TimerRunnable implements Runnable{
    private final Thread mainTread;

    public TimerRunnable(Thread mainTread){
        this.mainTread = mainTread;
    }

    @Override
    public void run(){
        try{
            for(int i = 10; i > 0; i--){
                System.out.println("   ⏳ (" + i + "초 남음...)");
                Thread.sleep(1000);
            }
            System.out.println("\n⏰ [타이머] 10초 제한 시간이 초과되었습니다!");
            mainTread.interrupt();
        }catch (InterruptedException e){
                System.out.println("유저가 입력하여 타이머를 종료합니다.");
        }
    }
}
