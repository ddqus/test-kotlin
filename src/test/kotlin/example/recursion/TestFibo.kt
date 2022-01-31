package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TestFibo {
    var counter = 0

    private fun fibo(n: Int): Int {
        val result = when {
            n == 0 -> 0
            n == 1 -> 1
            else -> {
                counter++
                fibo(n - 1) + fibo(n - 2)
            }
        }
        return result
    }

    @Test
    internal fun test() {
        assertThat(fibo(0)).isEqualTo(0)
        assertThat(fibo(1)).isEqualTo(1)
        assertThat(fibo(2)).isEqualTo(1)
        assertThat(fibo(3)).isEqualTo(2)
        assertThat(fibo(4)).isEqualTo(3)
    }

    @ParameterizedTest
    @MethodSource("geometricSeriesRecursionSource")
    internal fun `count recursion`(n: Int, expectedCount: Int) {
        // TODO 왜 counter가 초기화되지? 누적되야 하는데?
        assertThat(counter).isEqualTo(0)
        fibo(n)
        assertThat(counter).isEqualTo(expectedCount)
    }

    companion object {
        @JvmStatic
        fun geometricSeriesRecursionSource() = listOf(
            // 기하급수적으로 recursion 발생
            Arguments.of(18, 4180),
            Arguments.of(19, 6764),
            Arguments.of(20, 10945),
            Arguments.of(21, 17710),
        )
    }
}