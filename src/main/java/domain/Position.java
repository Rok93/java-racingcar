package domain;

public class Position {
    private static final String MIN_CAR_POSITION_NUMBER_NOTICE = "자동차 위치는 0이상만 가능합니다.";
    private static final int POSITION_MIN_VALUE = 0;

    private final int position;

    public Position() {
        this(POSITION_MIN_VALUE);
    }

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < POSITION_MIN_VALUE) {
            throw new IllegalArgumentException(MIN_CAR_POSITION_NUMBER_NOTICE);
        }
    }

    public int getPosition() {
        return position;
    }

    public Position move() {
        return new Position(position + 1);
    }
}
