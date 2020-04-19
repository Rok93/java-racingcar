package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.InputCarNameException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

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


    @DisplayName("차량 갯수가 2대 미만이면 예외를 발생한다")
    @Test
    void test_carNumberUnderTwoException() {
        //given
        List<Car> carNames = Arrays.asList(new Car("benz"));

        //when then
        assertThatThrownBy(() -> new Cars(carNames))
                .isExactlyInstanceOf(InputCarNameException.class);
    }

    @DisplayName("차량이 이름이 중복되면 예외를 발생한다")
    @Test
    void test_carNameDuplicatedException() {
        //given
        List<Car> carNames = Arrays.asList(new Car("benz"), new Car("benz"));

        //when then
        assertThatThrownBy(() -> new Cars(carNames))
                .isExactlyInstanceOf(InputCarNameException.class);
    }
}