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

    private void validateName(List<Car> carList) {
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

    public Cars play(Move move) {
        int carNumber = cars.size();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            carList.add(cars.get(i).goOrStop(move.isGo()));
        }
        return new Cars(carList);
    }
}
