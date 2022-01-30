package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestPower {
    private fun power(x: Double, n: Int): Double {
        val result: Double = when {
            n <= 1 -> x
            else -> x * power(x, n - 1)
        }
        return result
    }

    @Test
    internal fun `test power`() {
        assertThat(power(2.0, 3)).isEqualTo(8.0)
        assertThat(power(2.0, 31) - 1).isEqualTo(Int.MAX_VALUE.toDouble())
    }
}