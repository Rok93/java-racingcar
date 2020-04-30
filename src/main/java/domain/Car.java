package domain;

import java.util.Objects;

public class Car {
    private static final int STEP_FORWARD_STANDARD = 4;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this(new Name(name), new Position(position));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car goOrStop(int condition) {
        if (condition >= STEP_FORWARD_STANDARD) {
            return new Car(name, position.move());
        }
        return this;
    }

    public boolean matchPosition(int position) {
        return this.position.isEqualTo(position);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name.getName(), car.name.getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

