import controller.RacingGameSystem;
import domain.TryNumber;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        TryNumber tryNumber = InputView.inputTryNumber();

        RacingGameSystem racingGameSystem = new RacingGameSystem();
        racingGameSystem.generateCars(carNames);

        OutputView.printRunResult();
        for (int i = 0; i < tryNumber.getTryNumber(); i++) {
            racingGameSystem.play();
            OutputView.printCurrentPosition(racingGameSystem.getCars());
        }
        OutputView.printWinners(racingGameSystem.getWinners());
    }
}
