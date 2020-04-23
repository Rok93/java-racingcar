package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}