package example.factorial

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal

class FactorialFPTest {
    private val factorial: Factorial = FPFactorial()

    @Test
    internal fun instance() {
        Assertions.assertThat(factorial).isNotNull
    }

    @ParameterizedTest
    @MethodSource("example.factorial.FactorialDataSource#dataSource")
    internal fun test(n: Int, result: Int) {
        Assertions.assertThat(factorial.calc(n)).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("example.factorial.FactorialDataSource#bigDecimalDataSource")
    internal fun `test bigDecimal`(n: BigDecimal, result: BigDecimal) {
        Assertions.assertThat(factorial.calc(n)).isEqualTo(result)
    }

    @Test
    internal fun stackoverflow() {
        Assertions.assertThatThrownBy { factorial.calc(10000) }
            .isInstanceOf(StackOverflowError::class.java)
    }
}