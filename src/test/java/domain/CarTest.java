package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("Car 객체가 생성되는지 확인한다.")
    @Test
    public void testGenerateCar() {
        //given
        String carName = "benz";

        //when
        Car car = new Car(carName);

        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("Car 이름에 공백을 허용하지 않는다")
    @Test
    public void testCarNameContainGapException() {
        //given
        String carName = "a bmw";

        //when then
        assertThatThrownBy(() -> new Car(carName))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차량이 전진하는 테스트를 진행한다.")
    @Test
    void testGo() {
        //given
        boolean condition = true;
        Car car = new Car("car");

        //when
        Car nextCar = car.goOrStop(condition);
        int expectedPosition = 1;

        //then
        assertThat(nextCar.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("차량이 전진하지 않는 테스트를 진행한다.")
    @Test
    void testStop() {
        //given
        boolean condition = false;
        Car car = new Car("car");

        //when
        Car nextCar = car.goOrStop(condition);
        int expectedPosition = 0;

        //then
        assertThat(nextCar.getPosition()).isEqualTo(expectedPosition);
    }
}