package example.calculator1

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class MinusCalculatorTest {
    private fun createCalculator(): OopCalculator = MinusCalculator()

    @Test
    internal fun test() {
        val calculator = createCalculator()
        Assertions.assertThat(calculator).isNotNull
        Assertions.assertThat(calculator.calculate(1, 2)).isEqualTo(-1)
        Assertions.assertThat(calculator.calculate(13, 4)).isEqualTo(9)
    }
}