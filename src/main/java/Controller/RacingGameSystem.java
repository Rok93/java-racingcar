package Controller;

import domain.Car;
import utils.InputCarNameException;
import utils.InputPositionException;
import view.InputView;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGameSystem {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MIN_CAR_NUMBERS = 2;
    private static final String CAR_NUMBER_MIN_MESSAGE = "최소 2대의 차량이 있어야합니다.";
    private static final String CAR_NAME_DUPLICATED_MESSAGE = "차량의 이름은 중복되면 안됩니다.";
    private static final String COMMA = ",";

    private List<Car> cars;

    public RacingGameSystem() {
    }

    public RacingGameSystem(List<Car> cars) {
        this.cars = cars;
    }


    public List<Car> generateCars(String carNames) {
        try {
            cars = splitCarNames(carNames).stream()
                    .map(String::trim)
                    .map(Car::new)
                    .collect(Collectors.toList());

            isValidateCars(cars);
            return cars;
        } catch (InputCarNameException e) {
            return generateCars(InputView.inputCarNames()); // todo: 이 부분에 대한 처리 어떻게 해야하는가? view 영역을 아예 없애고 싶은데 예외 잡을때 문제가 된다. 한번 carNames를 받아오면 다시 받아올 수 있는 방법...?
        } catch (InputPositionException e) {
            return generateCars(InputView.inputCarNames());
        }
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(COMMA));
    }

    private static void isValidateCars(List<Car> carList) {
        isNotDuplicatedCarName(carList);
        isCarNumberSmallerThanTwo(carList);
    }

    private static void isNotDuplicatedCarName(List<Car> carList) {
        Set<Car> carSet = new HashSet<>(carList);
        if (carList.size() != carSet.size()) {
            throw new InputCarNameException(CAR_NAME_DUPLICATED_MESSAGE);
        }
    }

    private static void isCarNumberSmallerThanTwo(List<Car> carList) {
        if (carList.size() < MIN_CAR_NUMBERS) {
            throw new InputCarNameException(CAR_NUMBER_MIN_MESSAGE);
        }
    }

    public void play() {
        for (Car car : cars) {
            car.goOrStop(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * MAX_RANDOM_NUMBER);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition()) //todo: 메소드 참조로 변경할 수 있을 듯하다.
                .collect(Collectors.toList());
        return winners;
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

}