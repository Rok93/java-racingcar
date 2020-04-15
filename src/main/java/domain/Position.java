package domain;

import utils.InputPositionException;

import java.util.Objects;

public class Position {
    private static final String MIN_CAR_POSITION_NUMBER_NOTICE = "자동차 위치는 0이상만 가능합니다.";
    private static final int POSITION_MIN_VALUE = 0;

    private int position;

    public Position(int position) {
        isPositionSmallerThanZero(position);
        this.position = position;
    }

    private void isPositionSmallerThanZero(int position) {
        if (position < POSITION_MIN_VALUE) {
            throw new InputPositionException(MIN_CAR_POSITION_NUMBER_NOTICE);
        }
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
