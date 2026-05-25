package org.example.controller;

import org.example.runnable.StartBurnRunnable;
import org.example.runnable.TimerRunnable;
import org.example.domain.DatingPartner;
import org.example.domain.PartnerFactory;
import org.example.domain.Player;
import org.example.view.InputView;
import org.example.view.OutputView;

import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ScenarioController {
    public void start() {
        OutputView.printTitle();

        System.out.print("당신의 이름을 입력해 주세요: ");
        String playerName = InputView.readLine();
        Player player = new Player(playerName);
        System.out.println();

        OutputView.printSelectionMenu();
        int characterChoice = InputView.readIntWithRange(1, 4);

        // 팩토리 패턴을 통해 메인 흐름에서 객체 생성 책임을 분리
        DatingPartner partner = PartnerFactory.createPartner(characterChoice, player);

        // 캐릭터 고유의 등장 상황 출력
        partner.introduce();

        Thread mainThread = Thread.currentThread();

        // 프로그램 전체에서 단 한 번만 생성하고 공유하는 스레드 풀
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> timerTask = null;
        Future<?> statTask = null;

        try {
            // 1단계
            OutputView.printStep1Question();

            // 놀고 있는 스레드 풀의 일꾼들에게 작업 제출
            timerTask = executorService.submit(new TimerRunnable(mainThread));
            statTask = executorService.submit(new StartBurnRunnable(partner));

            int choice1 = InputView.readIntWithRange(1, 2);

            // 유저가 입력 완료했으므로 현재 진행 중인 태스크만 즉시 취소
            if (timerTask != null){
                timerTask.cancel(true);
            }
            if (statTask != null){
                statTask.cancel(true);
            }

            // [비즈니스 로직 연산 및 대사 반환] ➔ [View를 통한 출력 위임]
            String response1 = partner.respondStep1(choice1);
            OutputView.printPartnerResponse(response1);
            OutputView.printCurrentHeartRate(partner.getHeartRate());


            // 2단계
            OutputView.printStep2Question();

            // 대기실에서 대기 중인 일꾼들에게 다음 단계 작업 재할당
            timerTask = executorService.submit(new TimerRunnable(mainThread));
            statTask = executorService.submit(new StartBurnRunnable(partner));

            int choice2 = InputView.readIntWithRange(1, 2);

            if (timerTask != null){
                timerTask.cancel(true);
            }
            if (statTask != null){
                statTask.cancel(true);
            }

            String response2 = partner.respondStep2(choice2);
            OutputView.printPartnerResponse(response2);
            OutputView.printCurrentHeartRate(partner.getHeartRate());


            // 3단계
            OutputView.printStep3Question(partner.getName());

            timerTask = executorService.submit(new TimerRunnable(mainThread));
            statTask = executorService.submit(new StartBurnRunnable(partner));

            int choice3 = InputView.readIntWithRange(1, 2);

            if (timerTask != null){
                timerTask.cancel(true);
            }
            if (statTask != null){
                statTask.cancel(true);
            }

            String response3 = partner.respondStep3(choice3);
            OutputView.printPartnerResponse(response3);

        } catch (NoSuchElementException | IllegalStateException e) {
            OutputView.printTimeoutMessage(partner.getName());

            // 타임아웃 예외 발생 시에도 백그라운드 태스크 확실히 취소
            if (timerTask != null) {
                timerTask.cancel(true);
            }
            if (statTask != null) {
                statTask.cancel(true);
            }
        } finally {
            // 게임이 비정상 종료되든 완벽히 끝나든 마지막에 스레드 풀 전체를 완전히 안전하게 닫음
            executorService.shutdownNow();
        }

        // 최종 결과 정산 및 엔딩 분기 출력 위임
        OutputView.printFinalResult(partner);
    }
}
