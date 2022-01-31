package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TestReverseFP {
    companion object {
        @JvmStatic
        fun dataSource() = listOf(
            Arguments.of("", ""),
            Arguments.of("qwerty", "ytrewq"),
            Arguments.of("123456", "654321"),
        )
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    internal fun test(before: String, after: String) {
        assertThat(reverseFP(before)).isEqualTo(after)
    }

    private fun String.tail() = drop(1)

    private tailrec fun reverseFP(str: String, carry: String = ""): String {
        return when {
            str.isEmpty() -> carry
            else -> {
                reverseFP(str.tail(), str.first() + carry )
            }
        }
    }
}