package example.calculator2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TestHigherOrderCalculator {
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val minus: (Int, Int) -> Int = { x, y -> x - y }

    private fun calc(
        func: (Int, Int) -> Int,
        x: Int,
        y: Int,
    ): Int = func(x, y)

    @ParameterizedTest
    @MethodSource("dataSourcePlus")
    internal fun `test sum`(x: Int, y: Int, result: Int) {
        assertThat(calc(sum, x, y)).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("dataSourceMinus")
    internal fun `test minus`(x: Int, y: Int, result: Int) {
        assertThat(calc(minus, x, y)).isEqualTo(result)
    }

    companion object {
        @JvmStatic
        fun dataSourcePlus() = listOf(
            Arguments.of(1, 2, 3),
            Arguments.of(3, 4, 7),
        )

        @JvmStatic
        fun dataSourceMinus() = listOf(
            Arguments.of(1, 2, -1),
            Arguments.of(4, 3, 1),
        )
    }
}