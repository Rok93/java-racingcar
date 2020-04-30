import domain.Cars;
import domain.RacingGame;
import domain.TryNumber;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Cars cars = InputView.inputCarNames();
        TryNumber tryNumber = InputView.inputTryNumber();

        RacingGame racingGame = new RacingGame(cars, tryNumber);

        OutputView.printRunResult();
        OutputView.printRacingGameProcess(racingGame.playRacingGame());
        OutputView.printWinners(racingGame.getWinners());
    }
}
