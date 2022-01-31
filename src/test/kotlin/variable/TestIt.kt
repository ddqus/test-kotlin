package variable

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestIt {
    @Test
    internal fun test() {
        val items = listOf(1, 2, 3)
        val result1 = items
            .map { value -> value + 1 }
        assertThat(result1).isEqualTo(listOf(2, 3, 4))

        val result2 = items
            .map { it * 2 }
        assertThat(result2).isEqualTo(listOf(2, 4, 6))
    }
}