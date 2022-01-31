package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestPower {
    private tailrec fun power(x: Double, n: Int, carry: Double = 1.0): Double {
        return when (n) {
            0 -> carry
            else -> power(x, n - 1, x * carry)
        }
    }

    @Test
    internal fun `test power`() {
        assertThat(power(2.0, 3)).isEqualTo(8.0)
        assertThat(power(2.0, 31) - 1).isEqualTo(Int.MAX_VALUE.toDouble())
        assertThat(power(3.0, 3)).isEqualTo(27.0)
    }
}