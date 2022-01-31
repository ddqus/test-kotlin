package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestFibo {
    private fun fibo(n: Int): Int {
        val result = when {
            n == 0 -> 0
            n == 1 -> 1
            else -> fibo(n - 1) + fibo(n - 2)
        }
        return result
    }

    @Test
    internal fun test() {
        assertThat(fibo(0)).isEqualTo(0)
        assertThat(fibo(1)).isEqualTo(1)
        assertThat(fibo(2)).isEqualTo(1)
        assertThat(fibo(3)).isEqualTo(2)
        assertThat(fibo(4)).isEqualTo(3)
    }
}