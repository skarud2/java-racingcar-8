package racingcar;

import racingcar.controller.RacingController;

import java.util.InputMismatchException;
import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingService;

public class Application {

    public static void main(String[] args) {
        RacingService racingService = new RacingService();
        RacingController racingController = new RacingController();

        String names = "";
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                names = Console.readLine();
                racingService.validateCarNames(names);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int attempts = 0;
        while (true) {
            try {
                System.out.println("시도할 횟수는 몇 회인가요?");
                attempts = Integer.parseInt(Console.readLine());
                racingService.validateAttempts(attempts);
                break;
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        racingController.startRace(names, attempts);
    }
}
