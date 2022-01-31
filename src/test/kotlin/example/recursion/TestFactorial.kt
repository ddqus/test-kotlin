package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal

class TestFactorial {
    var counter = 0

    private fun factorial(n: BigDecimal): BigDecimal {
        val result = when {
            n <= BigDecimal.ONE -> BigDecimal.ONE
            else -> {
                counter++
                n * factorial(n - BigDecimal.ONE)
            }
        }
        return result
    }

    @Test
    internal fun test() {
        assertThat(factorial(BigDecimal("4")))
            .isEqualTo(BigDecimal("24"))
        assertThat(factorial(BigDecimal("50")))
            .isEqualTo(BigDecimal("30414093201713378043612608166064768844377641568960512000000000000"))
    }

    @ParameterizedTest
    @MethodSource("linearRecursionSource")
    internal fun counter(n: Int, count: Int) {
        assertThat(counter).isEqualTo(0)
        factorial(BigDecimal(n))
        assertThat(counter).isEqualTo(count)
    }

    companion object {
        @JvmStatic
        fun linearRecursionSource() = listOf(
            // factorial 은 n의 1승이니 선형적으로 증가한다?
            Arguments.of(10, 9),
            Arguments.of(11, 10),
            Arguments.of(50, 49),
        )
    }
}