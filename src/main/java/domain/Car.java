package domain;

import java.util.Objects;

public class Car {
    private static final int STEP_FORWARD_STANDARD = 4;

    private Name carName;
    private Position position;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int position) {
        this.carName = new Name(carName);
        this.position = new Position(position);
    }

    public void goOrStop(int random) {
        if (random >= STEP_FORWARD_STANDARD) {
            position.move();
        }
    }

    public boolean matchPosition(int position) {
        return this.position.getPosition() == position;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return carName.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

}

