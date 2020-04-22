package domain;

import java.util.Objects;

public class Car implements Cloneable {
    private static final int STEP_FORWARD_STANDARD = 4;
    public static final String HYPHEN = "-";

    private Name name;
    private Position position;

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

    public void goOrStop(int condition) {
        if (condition >= STEP_FORWARD_STANDARD) {
            this.position = position.move();
        }
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
    protected Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
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

