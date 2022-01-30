package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestReplicate {
    private fun replicate(n: Int, element: Int): List<Int> =
        when {
            n <= 1 -> listOf(element)
            else -> listOf(element).plus(replicate(n - 1, element))
        }

    @Test
    internal fun name() {
        assertThat(replicate(3, 5)).isEqualTo(listOf(5, 5, 5))
        assertThat(replicate(2, 11)).isEqualTo(listOf(11, 11))
    }
}