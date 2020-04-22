package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("Position이 증가한다")
    @Test
    void test_move() {
        //given
        Position position = new Position();

        //when
        position = position.move();

        //then
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @DisplayName("Position은 깊은 복사를 한다.")
    @Test
    void test_DeepCopyPosition() throws CloneNotSupportedException {
        //given
        Position position = new Position();

        //when
        Position copiedPosition = position.clone();

        //then
        assertThat(copiedPosition).isNotEqualTo(position);
    }
}