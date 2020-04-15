package controller;

import domain.Car;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGameSystem {
    private static final int MAX_RANDOM_NUMBER = 10;

    private List<Car> cars;

    public RacingGameSystem() {
    }

    public RacingGameSystem(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> generateCars(List<String> carNames) {
        cars = carNames.stream()
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
        return cars;
    }

    public void play() {
        for (Car car : cars) {
            car.goOrStop(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * MAX_RANDOM_NUMBER);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

}