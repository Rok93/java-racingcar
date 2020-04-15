package view;

import domain.TryNumber;
import utils.InputCarNameException;
import utils.InputTryNumberException;

import java.util.*;

public class InputView {
    private static Scanner input = new Scanner(System.in);
    private static final String INPUT_TRY_NUMBER_ONLY_NUMBER_MESSAGE = "숫자만 입력해주세요!";
    private static final String COMMA = ",";
    private static final int MIN_CAR_NUMBERS = 2;
    private static final String CAR_NUMBER_MIN_MESSAGE = "최소 2대의 차량이 있어야합니다.";
    private static final String CAR_NAME_DUPLICATED_MESSAGE = "차량의 이름은 중복되면 안됩니다.";

    public static List<String> inputCarNames() {
        OutputView.printInputCarNamesMessage();
        try {
            List<String> carNames = splitCarNames(input.nextLine());
            isValidateCars(carNames);
            return carNames;
        } catch (InputCarNameException e) {
            return inputCarNames();
        }
    }

    private static List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(COMMA));
    }

    private static void isValidateCars(List<String> carList) {
        isNotDuplicatedCarName(carList);
        isCarNumberSmallerThanTwo(carList);
    }

    private static void isNotDuplicatedCarName(List<String> carList) {
        Set<String> carSet = new HashSet<>(carList);
        if (carList.size() != carSet.size()) {
            throw new InputCarNameException(CAR_NAME_DUPLICATED_MESSAGE);
        }
    }

    private static void isCarNumberSmallerThanTwo(List<String> carList) {
        if (carList.size() < MIN_CAR_NUMBERS) {
            throw new InputCarNameException(CAR_NUMBER_MIN_MESSAGE);
        }
    }

    public static TryNumber inputTryNumber() {
        OutputView.printInputTryNumberMessage();
        try {
            return new TryNumber(input.nextInt());
        } catch (InputMismatchException e) {
            System.out.println(INPUT_TRY_NUMBER_ONLY_NUMBER_MESSAGE);
            return inputTryNumber();
        } catch (InputTryNumberException e) {
            return inputTryNumber();
        }
    }
}
