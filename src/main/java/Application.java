import domain.Cars;
import domain.RacingCarMovement;
import domain.RacingGame;
import domain.TryNumber;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Cars cars = InputView.inputCarNames();
        TryNumber tryNumber = InputView.inputTryNumber();

        RacingGame racingGame = new RacingGame(cars, tryNumber);

        OutputView.printRacingGameProcess(racingGame.playRacingGame(new RacingCarMovement()));
        OutputView.printWinners(racingGame.getWinners());
    }
}
