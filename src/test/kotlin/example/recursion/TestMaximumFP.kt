package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TestMaximumFP {
    companion object {
        @JvmStatic
        fun maximumSource() = listOf(
            Arguments.of(listOf(1), 1),
            Arguments.of(listOf(1, 2, 3, 4, 5), 5),
            Arguments.of(listOf(1, 8, 3, 4, 5), 8),
        )
    }

    @ParameterizedTest
    @MethodSource("maximumSource")
    internal fun test(items: List<Int>, maximum: Int) {
        assertThat(maximumFP(items)).isEqualTo(maximum)
    }

    private fun List<Int>.tail() = drop(1)

    private tailrec fun maximumFP(items: List<Int>, champion: Int = 0): Int {
        return when {
            items.isEmpty() -> champion
            else -> {
                val challenger = items.first()
                val maximum = if (challenger >= champion) challenger else champion
                maximumFP(items.tail(), maximum)
            }
        }
    }
}