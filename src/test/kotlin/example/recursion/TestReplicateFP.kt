package example.recursion

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TestReplicateFP {
    companion object {
        @JvmStatic
        fun dataSource() = listOf(
            Arguments.of(2, 3, listOf(2, 2, 2)),
            Arguments.of(5, 2, listOf(5, 5)),
        )
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    internal fun test(element: Int, repeat: Int, expect: List<Int>) {
        Assertions.assertThat(fp(element, repeat)).isEqualTo(expect)
    }

    private tailrec fun fp(element: Int, repeat: Int, carry: List<Int> = listOf()): List<Int> {
        return when {
            repeat == 0 -> carry
            else -> {
                fp(element, repeat - 1, carry.plus(element))
            }
        }
    }
}