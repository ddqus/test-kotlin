package example.recursion

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class TestFiboFP {
    private fun fibo(n: Int) = fiboFP(n, 0, 1)

    private tailrec fun fiboFP(n: Int, first: Int, second: Int): Int {
        return when (n) {
            0 -> first
            1 -> second
            else -> {
                fiboFP(n - 1, second, first + second)
            }
        }
    }

    @Test
    internal fun test() {
        Assertions.assertThat(fibo(0)).isEqualTo(0)
        Assertions.assertThat(fibo(1)).isEqualTo(1)
        Assertions.assertThat(fibo(2)).isEqualTo(1)
        Assertions.assertThat(fibo(3)).isEqualTo(2)
        Assertions.assertThat(fibo(4)).isEqualTo(3)
        Assertions.assertThat(fibo(6)).isEqualTo(8)
    }
}