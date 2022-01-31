package example.recursion

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TestElemFP {
    companion object {
        @JvmStatic
        fun dataSource() = listOf(
            Arguments.of(0, listOf(2, 3, 4), false),
            Arguments.of(1, listOf(2, 3, 4), false),
            Arguments.of(2, listOf(2, 3, 4), true),
            Arguments.of(3, listOf(2, 3, 4), true),
            Arguments.of(4, listOf(2, 3, 4), true),
            Arguments.of(5, listOf(2, 3, 4), false),
        )
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    internal fun test(find: Int, items: List<Int>, exist: Boolean) {
        Assertions.assertThat(fp(find, items)).isEqualTo(exist)
    }

    private fun List<Int>.tail() = drop(1)

    private tailrec fun fp(find: Int, items: List<Int>, carry: Boolean = false): Boolean {
        return when {
            items.isEmpty() -> carry
            else -> {
                fp(find, items.tail(), if (items.first() == find) true else carry)
            }
        }
    }
}