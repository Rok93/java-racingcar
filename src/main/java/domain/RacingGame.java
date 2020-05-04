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

    public List<Cars> playRacingGame(Move move) { //todo: 해당 코드에 대한 테스트 코드가 있으면 좋을 것 같다.
        int repetitionNumber = tryNumber.getTryNumber();
        List<Cars> carsList = new ArrayList<>();
        for (int i = 0; i < repetitionNumber; i++) {
            cars = cars.play(move);
            carsList.add(cars);
        }
        return carsList;
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    } //todo: 외부에 주솟값을 그대로 노출하면 어떻게 될까요?

    public Cars getCars() {
        return new Cars(cars.getCars());
    }

    public TryNumber getTryNumber() {
        return new TryNumber(tryNumber.getTryNumber());
    }
}
