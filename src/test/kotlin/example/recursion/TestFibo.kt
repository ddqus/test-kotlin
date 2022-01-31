package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestFibo {
    var counter = 0

    private fun fibo(n: Int): Int {
        counter++
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

    @Test
    internal fun `count recursion`() {
        assertThat(counter).isEqualTo(0)

        fibo(20)
        // 기하급수적으로 recursion 발생
        assertThat(counter).isEqualTo(21891)
    }
}