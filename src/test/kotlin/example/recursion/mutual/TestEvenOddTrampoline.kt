package example.recursion.mutual

import example.Bounce
import example.Done
import example.More
import example.trampoline
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestEvenOddTrampoline {
    @Test
    internal fun `using trampoline`() {
        assertThat(trampoline(even(999999))).isFalse
        assertThat(trampoline(even(999998))).isTrue
    }

    private fun even(n: Int): Bounce<Boolean> {
        return when (n) {
            0 -> Done(true)
            else -> More { odd(n - 1) }
        }
    }

    private fun odd(n: Int): Bounce<Boolean> {
        return when (n) {
            0 -> Done(false)
            else -> More { even(n - 1) }
        }
    }
}
