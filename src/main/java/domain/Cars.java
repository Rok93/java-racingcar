package domain;

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
        for (Car car : cars) {
            this.cars.add(new Car(car.getName(), car.getPosition()));
        }
    }

    private void validateCars(List<Car> cars) {
        validateName(cars);
        validateCarNumber(cars);
    }

    private void validateName(List<Car> cars) {
        int actualCarsSize = (int) cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (cars.size() != actualCarsSize) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED_MESSAGE);
        }
    }

    private void validateCarNumber(List<Car> cars) {
        if (cars.size() < MIN_CAR_NUMBERS) {
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
        return new ArrayList<>(cars);
    }

    public Cars play(Movement movement) {
        int carNumber = this.cars.size();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(this.cars.get(i).goOrStop(movement.isGo()));
        }
        return new Cars(cars);
    }
}
