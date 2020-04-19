import controller.RacingGameSystem;
import domain.Car;
import domain.Cars;
import domain.TryNumber;
import utils.InputCarNameException;
import utils.InputTryNumberException;
import view.InputView;
import view.OutputView;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        Cars cars = application.initCars();
        TryNumber tryNumber = application.initTryNumber();

        RacingGameSystem racingGameSystem = new RacingGameSystem(cars);

        OutputView.printRunResult();
        for (int i = 0; i < tryNumber.getTryNumber(); i++) {
            racingGameSystem.play();
            OutputView.printCurrentPosition(racingGameSystem.getCars());
        }
        OutputView.printWinners(racingGameSystem.getWinners());
    }

    public Cars initCars() {
        try {
            List<String> carNames = InputView.inputCarNames();
            List<Car> cars = generateCars(carNames);
            return new Cars(cars);
        } catch (InputCarNameException e) {
            return initCars();
        }
    }

    private List<Car> generateCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public TryNumber initTryNumber() {
        try {
            return new TryNumber(InputView.inputTryNumber());
        } catch (InputTryNumberException e) {
            return initTryNumber();
        } catch (InputMismatchException e) { //todo: 이부분 예외가 안잡힘...
            OutputView.printInputMismatchMessage();
            return initTryNumber();
        }
    }
}
