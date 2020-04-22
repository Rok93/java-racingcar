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
        int randomNumber = 4; //todo: 변수명 고민, 아래도 동일
        Car car = new Car("car");

        //when
        car.goOrStop(randomNumber);
        int expectedPosition = 1;

        //then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("차량이 전진하지 않는 테스트를 진행한다.")
    @Test
    void testStop() {
        //given
        int randomNumber = 3;
        Car car = new Car("car");

        //when
        car.goOrStop(randomNumber);
        int expectedPosition = 0;

        //then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("Car는 깊은 복사를 한다")
    @Test
    void test_Car_DeepCopy() throws CloneNotSupportedException {
        //given
        String carName = "benz";
        Car benz = new Car(carName);

        //when
        Car copiedBenz = benz.clone();

        //then
        assertThat(copiedBenz.hashCode()).isNotEqualTo(benz.hashCode());
    }
}