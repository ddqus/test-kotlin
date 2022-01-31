package example.recursion.mutual

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TestSquareRoot {
    companion object {
        @JvmStatic
        fun dataSource() = listOf(
            Arguments.of(5.0, 0.528685631720282),
        )
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    internal fun test(n: Double, result: Double) {
        assertThat(fp(n)).isEqualTo(result)
    }

    private fun fp(n: Double) = squareRoot(n)

    private fun squareRoot(n: Double): Double {
        return when {
            n < 1 -> n
            else -> {
                val myLogic = Math.sqrt(n)
                divideTwo(myLogic)
            }
        }
    }

    private fun divideTwo(n: Double): Double {
        return when {
            n < 1 -> n
            else -> {
                val myLogic = n / 2
                squareRoot(myLogic)
            }
        }
    }
}