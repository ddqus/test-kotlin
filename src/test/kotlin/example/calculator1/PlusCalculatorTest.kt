package example.calculator1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PlusCalculatorTest {

    private fun createCalculator(): OopCalculator = PlusCalculator()

    @Test
    internal fun test() {
        val calculator = createCalculator()
        assertThat(calculator).isNotNull
        assertThat(calculator.calculate(1, 2)).isEqualTo(3)
        assertThat(calculator.calculate(3, 4)).isEqualTo(7)
    }
}