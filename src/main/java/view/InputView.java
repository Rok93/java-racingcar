package view;

import java.util.*;

public class InputView {
    private static final String COMMA = ",";

    private static Scanner input = new Scanner(System.in);

    public static List<String> inputCarNames() {
        OutputView.printInputCarNamesMessage();
        String carNames = input.nextLine();
        return Arrays.asList(carNames.split(COMMA));
    }

    public static int inputTryNumber() {
        OutputView.printInputTryNumberMessage();
        return input.nextInt();
    }
}
