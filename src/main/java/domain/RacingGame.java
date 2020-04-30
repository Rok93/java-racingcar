package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private Cars cars;
    private final TryNumber tryNumber;

    public RacingGame(Cars cars, TryNumber tryNumber) {
        this.cars = new Cars(cars.getCars());
        this.tryNumber = new TryNumber(tryNumber.getTryNumber());
    }

    public List<Cars> playRacingGame() {
        int repetitionNumber = tryNumber.getTryNumber();
        List<Cars> carsList = new ArrayList<>();
        for (int i = 0; i < repetitionNumber; i++) {
            cars = cars.play();
            carsList.add(cars);
        }
        return carsList;
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

    public Cars getCars() {
        return new Cars(cars.getCars());
    }

    public TryNumber getTryNumber() {
        return new TryNumber(tryNumber.getTryNumber());
    }
}
