package example

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class PartialFunctionTest {
    @Test
    internal fun name() {
        val condition: (Int) -> Boolean = { it in 1..3 }
        val body: (Int) -> String = {
            when (it) {
                1 -> "a"
                2 -> "b"
                3 -> "c"
                else -> throw IllegalArgumentException()
            }
        }

        val partialFunction = PartialFunction(condition, body)
        assertThat(partialFunction.isDefinedAt(3)).isTrue
        assertThat(partialFunction(3)).isEqualTo("c")

        assertThat(partialFunction.isDefinedAt(4)).isFalse
        assertThatThrownBy { partialFunction(4) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("4 isn't supported")

    }

    @Test
    internal fun `test even`() {
        val isEven = PartialFunction<Int, Boolean>(
            { it % 2 == 0 },
            { it % 2 == 0 },
        )
        assertThat(isEven.isDefinedAt(1)).isFalse
        assertThat(isEven(2)).isTrue
        assertThat(isEven.isDefinedAt(3)).isFalse
        assertThat(isEven(4)).isTrue
    }

    private fun <P, R> ((P) -> R).toPartialFunction(definedAt: (P) -> Boolean)
            : PartialFunction<P, R> {
        return PartialFunction(definedAt, this)
    }

    @Test
    internal fun `test extended`() {
        val condition: (Int) -> Boolean = { it % 2 == 0 }
        val body: (Int) -> Boolean = { it % 2 == 0 }
        val isEven = body.toPartialFunction(condition)

        assertThat(isEven.isDefinedAt(1)).isFalse
        assertThat(isEven(2)).isTrue
        assertThat(isEven.isDefinedAt(3)).isFalse
        assertThat(isEven(4)).isTrue
    }
}
