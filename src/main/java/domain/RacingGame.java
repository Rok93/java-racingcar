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

    public List<Cars> playRacingGame(Movement movement) {
        int repetitionNumber = tryNumber.getTryNumber();
        List<Cars> cars = new ArrayList<>();
        for (int i = 0; i < repetitionNumber; i++) {
            this.cars = this.cars.play(movement);
            cars.add(this.cars);
        }
        return cars;
    }

    public List<Car> getWinners() {
        return new ArrayList<>(cars.getWinners());
    }

    public Cars getCars() {
        return new Cars(cars.getCars());
    }

    public TryNumber getTryNumber() {
        return new TryNumber(tryNumber.getTryNumber());
    }
}
