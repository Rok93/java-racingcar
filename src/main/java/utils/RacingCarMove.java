package utils;

public class RacingCarMove implements Move {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int STEP_FORWARD_STANDARD = 4;

    @Override
    public boolean isGo() {
        int randomNumber = (int) (Math.random() * MAX_RANDOM_NUMBER);
        return randomNumber >= STEP_FORWARD_STANDARD;
    }
}
