package controller;

import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameSystemTest {

    private RacingGameSystem racingGameSystem;

    @DisplayName("차량을 생성하는 기능을 테스트한다")
    @Test
    void test_generateCars() {
        //given
        List<Car> carNames = Arrays.asList(new Car("benz"), new Car("zeep"), new Car("kia"));

        //when
        Cars cars = new Cars(carNames);

        //then
        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars()).contains(new Car("benz"), new Car("zeep"), new Car("kia"));
    }

    @DisplayName("승자를 얻는 기능을 테스트를 한다")
    @Test
    void test_getWinners() {
        //given
        Car benz = new Car("benz", 5);
        Car kia = new Car("kia", 3);
        Car zeep = new Car("zeep", 5);
        Car honda = new Car("honda", 2);
        Cars cars = new Cars(Arrays.asList(benz, kia, zeep, honda));
        racingGameSystem = new RacingGameSystem(cars);

        //when
        List<Car> winners = racingGameSystem.getWinners();

        //then
        assertThat(winners).hasSize(2);
        assertThat(winners).contains(benz, zeep);
    }
}