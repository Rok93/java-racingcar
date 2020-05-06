package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("Position이 증가한다")
    @Test
    void test_moveFunction() {
        //given
        Position position = new Position();

        //when
        position = position.move();

        //then
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @DisplayName("Position의 position 값이 입력받은 값과 같은지 확인한다")
    @Test
    void test_isEqualTo() {
        //given
        Position position = new Position();
        position = position.move();

        //when
        boolean matchResult = position.isEqualTo(1);

        //then
        assertThat(matchResult).isTrue();
    }

    @DisplayName("position이 최솟값 보다 작으면 예외를 발생한다")
    @Test
    void test_initPositionValueNumber() {
        //given
        int positionNumber = -1;

        //when then
        assertThatThrownBy(() -> new Position(positionNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}