package utils;

public class RandomUtil {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int STEP_FORWARD_STANDARD = 4;

    public static boolean isGo() {
        int randomNumber = (int) (Math.random() * MAX_RANDOM_NUMBER);
        if (randomNumber >= STEP_FORWARD_STANDARD) {
            return true;
        }
        return false;
    }
}
