package domain;

import java.util.Objects;

public class Car {
    private static final int STEP_FORWARD_STANDARD = 4;
    public static final String HYPHEN = "-";

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
        return new Car(name, position);
    }

    public boolean matchPosition(int position) {
        return this.position.getPosition() == position;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public String printCar() {
        return name.getName() + ": " + printPosition(position.getPosition()) + "\n";
    }

    private static String printPosition(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(HYPHEN);
        }
        return sb.toString();
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

