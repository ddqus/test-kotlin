package example.factorial

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal

internal class TrampolineFactorialTest {
    private val factorial: Factorial = TrampolineFactorial()

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
        assertThat(factorial.calc(10000)).isNotNull
        assertThat(factorial.calc(100000)).isNotNull
    }
}