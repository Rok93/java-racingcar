package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("RacingGame 객체를 생성한다")
    @Test
    void testGenerateRacingGame() {
        //given
        Car benz = new Car("benz");
        Car bmw = new Car("bmw");
        Cars cars = new Cars(Arrays.asList(benz, bmw));
        int number = 2;
        TryNumber tryNumber = new TryNumber(number);

        //when
        RacingGame racingGame = new RacingGame(cars, tryNumber);

        //then
        assertThat(racingGame.getCars()).isNotEqualTo(cars);
        assertThat(racingGame.getCars().getCars()).contains(benz, bmw);
        assertThat(racingGame.getTryNumber()).isNotEqualTo(tryNumber);
        assertThat(racingGame.getTryNumber().getTryNumber()).isEqualTo(number);
    }

    @DisplayName("레이싱게임을 플레이하는 기능을 테스트한다")
    @Test
    void test_playRacingGame() {
        //given
        Car benz = new Car("benz");
        Car bmw = new Car("bmw");
        Cars cars = new Cars(Arrays.asList(benz, bmw));
        int carNumber = cars.getCars().size();
        int number = 2;
        TryNumber tryNumber = new TryNumber(number);

        //when
        RacingGame racingGame = new RacingGame(cars, tryNumber);
        List<Cars> result = racingGame.playRacingGame(() -> true);
        Cars resultCars1 = result.get(0);
        Cars resultCars2 = result.get(1);

        //then
        assertThat(resultCars1.getCars().size()).isEqualTo(carNumber);
        assertThat(resultCars1.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(resultCars1.getCars().get(1).getPosition()).isEqualTo(1);
        assertThat(resultCars1.getMaxPosition()).isEqualTo(1);

        assertThat(resultCars2.getCars().size()).isEqualTo(carNumber);
        assertThat(resultCars2.getCars().get(0).getPosition()).isEqualTo(2);
        assertThat(resultCars2.getCars().get(1).getPosition()).isEqualTo(2);
        assertThat(resultCars2.getMaxPosition()).isEqualTo(2);
    }
}