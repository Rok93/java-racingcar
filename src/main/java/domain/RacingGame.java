package domain;

import java.util.stream.Collectors;

public class RacingGame {
    private Cars cars;
    private final TryNumber tryNumber;

    public RacingGame(Cars cars, TryNumber tryNumber) {
        this.cars = new Cars(cars.getCars());
        this.tryNumber = new TryNumber(tryNumber.getTryNumber());
    }

    public String playRacingGame() {
        StringBuilder racingGameProcess = new StringBuilder();
        int repetitionNumber = tryNumber.getTryNumber();
        for (int i = 0; i < repetitionNumber; i++) {
            cars.play();
            racingGameProcess.append(getOneProcessResult() + "\n");
        }
        return racingGameProcess.toString();
    }

    private String getOneProcessResult() {
        return cars.getCars().stream()
                .map(Car::printCar)
                .collect(Collectors.joining());
    }

    public Cars getCars() {
        return new Cars(cars.getCars());
    }

    public TryNumber getTryNumber() {
        return new TryNumber(tryNumber.getTryNumber());
    }
}
