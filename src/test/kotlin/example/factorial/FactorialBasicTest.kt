package example.factorial

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class FactorialBasicTest {
    private val factorial: Factorial = BasicFactorial()

    @Test
    internal fun instance() {
        assertThat(factorial).isNotNull
    }

    @ParameterizedTest
    @MethodSource("example.factorial.FactorialDataSource#dataSource")
    internal fun test(n: Int, result: Int) {
        assertThat(run(n)).isEqualTo(result)
    }

    private fun run(n: Int): Int {
        return factorial.calc(n)
    }
}
