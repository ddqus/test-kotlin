package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestGcd {
    private fun gcd(left: Int, right: Int): Int {
        println("left: $left right: $right")
        val result: Int = when {
            right == 0 -> left
            else -> gcd(right, left % right)
        }
        return result
    }

    @Test
    internal fun test() {
        assertThat(gcd(32, 13)).isEqualTo(1)
        assertThat(gcd(16, 20)).isEqualTo(4)
    }
}
