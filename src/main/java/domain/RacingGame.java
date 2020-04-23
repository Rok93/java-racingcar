package domain;

public class RacingGame {
    private Cars cars;
    private final TryNumber tryNumber;

    public RacingGame(Cars cars, TryNumber tryNumber) {
        this.cars = new Cars(cars.getCars());
        this.tryNumber = new TryNumber(tryNumber.getTryNumber());
    }

    public String playRacingGame() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tryNumber.getTryNumber(); i++) {
            sb.append(cars.play() + "\n");
        }
        return sb.toString();
    }

    public Cars getCars() {
        return cars;
    }

    public TryNumber getTryNumber() {
        return tryNumber;
    }
}
