import domain.Cars;
import domain.RacingGame;
import domain.TryNumber;
import utils.RacingCarMove;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Cars cars = InputView.inputCarNames();
        TryNumber tryNumber = InputView.inputTryNumber();

        RacingGame racingGame = new RacingGame(cars, tryNumber);

        OutputView.printRunResult();
        OutputView.printRacingGameProcess(racingGame.playRacingGame(new RacingCarMove()));
        OutputView.printWinners(racingGame.getWinners());
    }
}
