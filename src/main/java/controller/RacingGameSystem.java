package controller;

import domain.Car;
import domain.Cars;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGameSystem {
    private static final int MAX_RANDOM_NUMBER = 10;

    private Cars cars;

    public RacingGameSystem(Cars cars) {
        this.cars = cars;
    }

    public void play() {
        for (Car car : cars.getCars()) {
            car.goOrStop(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * MAX_RANDOM_NUMBER);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.getCars().stream()
                .filter(car -> car.matchPosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

}