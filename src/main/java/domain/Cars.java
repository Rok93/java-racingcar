package domain;

import utils.InputCarNameException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final int MIN_CAR_NUMBERS = 2;
    private static final String CAR_NUMBER_MIN_MESSAGE = "최소 2대의 차량이 있어야합니다.";
    private static final String CAR_NAME_DUPLICATED_MESSAGE = "차량의 이름은 중복되면 안됩니다.";

    private List<Car> cars;

    public Cars(List<Car> cars) {
        isValidateCars(cars);
        this.cars = cars;
    }

    private void isValidateCars(List<Car> carList) {
        isNotDuplicatedCarName(carList);
        isCarNumberSmallerThanTwo(carList);
    }

    private void isNotDuplicatedCarName(List<Car> carList) {
        Set<Car> carSet = new HashSet<>(carList);
        if (carList.size() != carSet.size()) {
            throw new InputCarNameException(CAR_NAME_DUPLICATED_MESSAGE);
        }
    }

    private void isCarNumberSmallerThanTwo(List<Car> carList) {
        if (carList.size() < MIN_CAR_NUMBERS) {
            throw new InputCarNameException(CAR_NUMBER_MIN_MESSAGE);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
