package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @DisplayName("차량을 생성하는 기능을 테스트한다")
    @Test
    void test_generateCars() {
        //given
        Car benz = new Car("benz");
        Car zeep = new Car("zeep");
        Car kia = new Car("kia");
        List<Car> carNames = Arrays.asList(benz, zeep, kia);

        //when
        Cars cars = new Cars(carNames);

        //then
        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars()).contains(benz, zeep, kia);
    }


    @DisplayName("차량 갯수가 2대 미만이면 예외를 발생한다")
    @Test
    void test_carNumberUnderTwoException() {
        //given
        List<Car> carNames = Arrays.asList(new Car("benz"));

        //when then
        assertThatThrownBy(() -> new Cars(carNames))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차량이 이름이 중복되면 예외를 발생한다")
    @Test
    void test_carNameDuplicatedException() {
        //given
        List<Car> carNames = Arrays.asList(new Car("benz"), new Car("benz"));

        //when then
        assertThatThrownBy(() -> new Cars(carNames))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Cars는 깊은복사를 한다")
    @Test
    void test_carsDeepCopy() {
        //given
        Car benz = new Car("benz");
        Car kia = new Car("kia");

        //when
        Cars cars = new Cars(Arrays.asList(benz, kia));
        Car copyBenz = cars.getCars().get(0);
        Car copyKia = cars.getCars().get(1);

        //then
        assertThat(copyBenz.hashCode()).isNotEqualTo(benz.hashCode());
        assertThat(copyKia.hashCode()).isNotEqualTo(kia.hashCode());
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

        //when
        List<Car> winners = cars.getWinners();

        //then
        assertThat(winners).hasSize(2);
        assertThat(winners).contains(benz, zeep);
    }

    @DisplayName("모든 자동차를 한 보 전진시키는 싸이클을 진행한다")
    @Test
    void test_playFunction1() {
        //given
        Cars cars = new Cars(Arrays.asList(new Car("benz"), new Car("zeep"), new Car("kia")));

        //when
        cars = cars.play(() -> true);

        //then
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);
    }

    @DisplayName("모든 자동차를 정지하는 싸이클을 진행한다")
    @Test
    void test_playFunction2() {
        //given
        Cars cars = new Cars(Arrays.asList(new Car("benz"), new Car("zeep"), new Car("kia")));

        //when
        cars = cars.play(() -> false);

        //then
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(0);
    }
}