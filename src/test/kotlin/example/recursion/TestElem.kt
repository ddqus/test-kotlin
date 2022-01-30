package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestElem {
    private fun List<Int>.tail() = drop(1)

    private fun elem(find: Int, list: List<Int>): Boolean {
        val result = when {
            list.isEmpty() -> false
            list.first() == find -> true
            else -> elem(find, list.tail())
        }
        return result
    }

    @Test
    internal fun test() {
        assertThat(elem(0, listOf(2, 3, 4))).isFalse
        assertThat(elem(1, listOf(2, 3, 4))).isFalse
        assertThat(elem(2, listOf(2, 3, 4))).isTrue
        assertThat(elem(3, listOf(2, 3, 4))).isTrue
    }
}