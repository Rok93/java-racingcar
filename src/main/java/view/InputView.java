package view;

import domain.Car;
import domain.Cars;
import domain.TryNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String COMMA = ",";

    private static Scanner input = new Scanner(System.in);

    public static Cars inputCarNames() {
        OutputView.printInputCarNamesMessage();
        try {
            String carNames = input.nextLine();
            List<Car> cars = Arrays.stream(carNames.split(COMMA))
                    .map(Car::new)
                    .collect(Collectors.toList());
            return new Cars(cars);
        } catch (IllegalArgumentException e) {
            return inputCarNames();
        }
    }

    public static TryNumber inputTryNumber() {
        OutputView.printInputTryNumberMessage();
        try {
            return new TryNumber(input.nextInt());
        } catch (IllegalArgumentException e) {
            return inputTryNumber();
        }
    }
}
