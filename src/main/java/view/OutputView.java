package view;

import domain.Car;
import domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_NUMBER_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다. ";
    private static final String RUN_RESULT_MESSAGE = "실행 결과 ";
    public static final String HYPHEN = "-";

    public static void printRacingGameProcess(List<Cars> carsList) {
        for (Cars cars : carsList) {
            cars.getCars().stream()
                    .map(OutputView::printCar)
                    .forEach(System.out::print);
            System.out.println();
        }
    }

    private static String printCar(Car car) {
        return car.getName() + ": " + printPosition(car.getPosition()) + "\n";
    }

    private static String printPosition(int position) {
        StringBuilder currentPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            currentPosition.append(HYPHEN);
        }
        return currentPosition.toString();
    }

    public static void printRunResult() {
        System.out.println(RUN_RESULT_MESSAGE);
    }

    public static void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public static void printInputTryNumberMessage() {
        System.out.println(INPUT_TRY_NUMBER_MESSAGE);
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + FINAL_WINNER_MESSAGE);
    }
}
