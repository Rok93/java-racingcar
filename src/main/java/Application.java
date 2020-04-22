import domain.Cars;
import domain.TryNumber;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Cars cars = InputView.inputCarNames();
        TryNumber tryNumber = InputView.inputTryNumber();

        OutputView.printRunResult();
        for (int i = 0; i < tryNumber.getTryNumber(); i++) {
            OutputView.printCurrentPosition(cars.play());
        }
        OutputView.printWinners(cars.getWinners());
    }
}
