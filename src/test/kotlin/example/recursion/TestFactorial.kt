package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal

class TestFactorial {
    var counter = 0
    var memo = Array(100, { BigDecimal(-1) })

    private fun factorial(n: BigDecimal): BigDecimal {
        val index = n.toInt()
        val result = when {
            n <= BigDecimal.ONE -> BigDecimal.ONE
            memo[index] != BigDecimal(-1) -> memo[index]
            else -> {
                counter++
                memo[index] = n * factorial(n - BigDecimal.ONE)
                memo[index]
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
    @MethodSource("memoizationRecursionSource")
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

        @JvmStatic
        fun memoizationRecursionSource() = listOf(
            // memo를 사용해도 횟수는 동일하다
            Arguments.of(10, 9),
            Arguments.of(11, 10),
            Arguments.of(50, 49),
        )
    }
}