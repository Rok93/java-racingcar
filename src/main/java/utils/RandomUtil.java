package utils;

public class RandomUtil {
    private static final int MAX_RANDOM_NUMBER = 10;

    public static int generateRandomNumber() {
        return (int) (Math.random() * MAX_RANDOM_NUMBER);
    }
}
