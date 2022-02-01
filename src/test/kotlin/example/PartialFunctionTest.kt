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

    @Test
    internal fun `test invokeElse`() {
        val condition: (Int) -> Boolean = { it % 2 == 0 }
        val body: (Int) -> Boolean = { it % 2 == 0 }
        val isEven = body.toPartialFunction(condition)

        assertThat(isEven.invokeOrElse(1, true)).isTrue
        assertThat(isEven.invokeOrElse(1, false)).isFalse
        assertThat(isEven.invokeOrElse(2, true)).isTrue
        assertThat(isEven.invokeOrElse(2, false)).isTrue
    }

    @Test
    internal fun `test orElse`() {
        val conditionA: (Int) -> Boolean = { it % 2 == 0 }
        val bodyA: (Int) -> String = { "$it is 2의 배수" }
        val isTwo = bodyA.toPartialFunction(conditionA)

        val conditionB: (Int) -> Boolean = { it % 3 == 0 }
        val bodyB: (Int) -> String = { "$it is 3의 배수" }
        val isThree = bodyB.toPartialFunction(conditionB)

        assertThatThrownBy { isTwo(1) }
            .hasMessage("1 isn't supported")
        assertThat(isTwo(2)).isEqualTo("2 is 2의 배수")
        assertThatThrownBy { isTwo(3) }
            .hasMessage("3 isn't supported")

        assertThatThrownBy { isThree(1) }
            .hasMessage("1 isn't supported")
        assertThatThrownBy { isThree(2) }
            .hasMessage("2 isn't supported")
        assertThat(isThree(3)).isEqualTo("3 is 3의 배수")

        assertThat(isTwo(6)).isEqualTo("6 is 2의 배수")
        assertThat(isThree(6)).isEqualTo("6 is 3의 배수")

        val isTwoOrThree = isTwo.orElse(isThree)
        assertThatThrownBy { isTwoOrThree(1) }
            .hasMessage("1 isn't supported")
        assertThat(isTwoOrThree(2)).isEqualTo("2 is 2의 배수")
        assertThat(isTwoOrThree(3)).isEqualTo("3 is 3의 배수")
        assertThat(isTwoOrThree(6)).isEqualTo("6 is 2의 배수")
    }
}
