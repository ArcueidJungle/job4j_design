package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

class BackwardArrayItTest {

    @Test
    void checkIntAfterIterator() {
        int[] array = new int[] {1, 2, 3, 4};
        int[] expectedArray = new int[] {1, 2, 3, 4};
        BackwardArrayIt iterator = new BackwardArrayIt(array);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(array).isEqualTo(expectedArray);
}



    @Test
    void whenMultiCallHasNextThenTrue() {
        BackwardArrayIt iterator = new BackwardArrayIt(
                new int[] {1, 2, 3, 4}
        );
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    void whenMultiCallHasNextThenNext() {
        BackwardArrayIt iterator = new BackwardArrayIt(
                new int[] {1, 2, 3}
        );
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(3);

    }

    @Test
    void whenReadSequence() {
        BackwardArrayIt iterator = new BackwardArrayIt(
                new int[] {1, 2, 3}
        );
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    void whenNextFromEmpty() {
        BackwardArrayIt iterator = new BackwardArrayIt(
                new int[] {}
        );
        assertThatThrownBy(iterator::next)
                .isInstanceOf(NoSuchElementException.class);
    }
}