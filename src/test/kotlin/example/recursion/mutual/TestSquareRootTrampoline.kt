package example.recursion.mutual

import example.Bounce
import example.Done
import example.More
import example.trampoline
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TestSquareRootTrampoline {
    companion object {
        @JvmStatic
        fun dataSource() = listOf(
            Arguments.of(5.0, 0.528685631720282),
        )
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    internal fun test(n: Double, result: Double) {
        Assertions.assertThat(fp(n)).isEqualTo(result)
    }

    private fun fp(n: Double) = trampoline(squareRoot(n))

    private fun squareRoot(n: Double): Bounce<Double> {
        return when {
            n < 1 -> Done(n)
            else -> {
                val myLogic = Math.sqrt(n)
                More { divideTwo(myLogic) }
            }
        }
    }

    private fun divideTwo(n: Double): Bounce<Double> {
        return when {
            n < 1 -> Done(n)
            else -> {
                val myLogic = n / 2
                More { squareRoot(myLogic) }
            }
        }
    }
}