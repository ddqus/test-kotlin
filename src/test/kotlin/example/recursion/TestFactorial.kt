package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class TestFactorial {
    private fun factorial(n: BigDecimal): BigDecimal {
        val result = when {
            n <= BigDecimal.ONE -> BigDecimal.ONE
            else -> n * factorial(n - BigDecimal.ONE)
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
}