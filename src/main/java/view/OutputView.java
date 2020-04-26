package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_NUMBER_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다. ";
    private static final String RUN_RESULT_MESSAGE = "실행 결과 ";
    private static final String INPUT_TRY_NUMBER_ONLY_NUMBER_MESSAGE = "숫자만 입력해주세요!";

    public static void printRacingGameProcess(String currentPositions) {
        System.out.println(currentPositions);
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

    public static void printInputMismatchMessage() {
        System.out.println(INPUT_TRY_NUMBER_ONLY_NUMBER_MESSAGE);
    }

}
