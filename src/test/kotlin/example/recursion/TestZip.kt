package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestZip {
    private fun List<Int>.tail() = drop(1)

    private fun zip(left: List<Int>, right: List<Int>): List<Pair<Int, Int>> {
        val result: List<Pair<Int, Int>> = when {
            left.isEmpty() || right.isEmpty() -> listOf()
            else ->
                listOf(
                    Pair(
                        left.first(),
                        right.first()
                    )
                )
                    .plus(
                        zip(
                            left.tail(),
                            right.tail()
                        )
                    )
        }
        return result
    }

    @Test
    internal fun test() {
        assertThat(zip(listOf(1, 3, 5), listOf(2, 4)).toString())
            .isEqualTo("[(1, 2), (3, 4)]")
    }
}