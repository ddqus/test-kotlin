package example.recursion.mutual

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestEvenOdd {
    @Test
    internal fun test() {
        assertThat(even(9998)).isTrue
        assertThat(even(9999)).isFalse
        assertThat(odd(9998)).isFalse
        assertThat(odd(9999)).isTrue
//        assertThat(odd(99999)).isTrue
    }

    private fun even(n: Int): Boolean {
        return when (n) {
            0 -> true
            else -> odd(n - 1)
        }
    }

    private fun odd(n: Int): Boolean {
        return when (n) {
            0 -> false
            else -> even(n - 1)
        }
    }
}