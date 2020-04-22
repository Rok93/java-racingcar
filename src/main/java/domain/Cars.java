package domain;

import utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MIN_CAR_NUMBERS = 2;
    private static final String CAR_NUMBER_MIN_MESSAGE = "최소 2대의 차량이 있어야합니다.";
    private static final String CAR_NAME_DUPLICATED_MESSAGE = "차량의 이름은 중복되면 안됩니다.";

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        validateCars(cars);
        for (Car car : cars) { //todo: ArrayList의 경우 addAll() 이라는 메서드로 깊은 복사가 가능하다고 하던데 생각한대로 잘 안됌
            this.cars.add(new Car(car.getName(), car.getPosition()));
        }
    }

    private void validateCars(List<Car> cars) {
        validateName(cars);
        validateCarNumber(cars);
    }

    private void validateName(List<Car> carList) { // Set <--> List의 Size 차이를 파악해서 해결할려고 했는데 생각대로 잘 안됌
        int actualCarsSize = (int) carList.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (carList.size() != actualCarsSize) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED_MESSAGE);
        }
    }

    private void validateCarNumber(List<Car> carList) {
        if (carList.size() < MIN_CAR_NUMBERS) {
            throw new IllegalArgumentException(CAR_NUMBER_MIN_MESSAGE);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition))
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return this.cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return cars;
    }

    public String play() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            car.goOrStop(RandomUtil.generateRandomNumber());
            sb.append(car.printCar());
        }
        return sb.toString();
    }
}
