package example.factorial

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal

internal class FactorialBasicTest {
    private val factorial: Factorial = BasicFactorial()

    @Test
    internal fun instance() {
        assertThat(factorial).isNotNull
    }

    @ParameterizedTest
    @MethodSource("example.factorial.FactorialDataSource#dataSource")
    internal fun test(n: Int, result: Int) {
        assertThat(factorial.calc(n)).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("example.factorial.FactorialDataSource#bigDecimalDataSource")
    internal fun `test bigDecimal`(n: BigDecimal, result: BigDecimal) {
        assertThat(factorial.calc(n)).isEqualTo(result)
    }

    @Test
    internal fun stackoverflow() {
        assertThatThrownBy { factorial.calc(10000) }
            .isInstanceOf(StackOverflowError::class.java)
    }
}
