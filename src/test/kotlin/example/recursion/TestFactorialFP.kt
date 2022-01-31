package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TestFactorialFP {
    private fun factorial(n: Int) = factorialFP(n, 1)

    private tailrec fun factorialFP(n: Int, carry: Int): Int {
        return when (n) {
            0 -> 1
            1 -> carry
            else -> {
                factorialFP(n - 1, n * carry)
            }
        }
    }

    @ParameterizedTest
    @MethodSource("factorialSource")
    internal fun test(n: Int, result: Int) {
        assertThat(factorial(n)).isEqualTo(result)
    }

    companion object {
        @JvmStatic
        fun factorialSource() = listOf(
            Arguments.of(0, 1),
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(3, 6),
            Arguments.of(4, 24),
        )
    }
}