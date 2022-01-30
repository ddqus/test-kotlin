package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class TestMaximum {
    private fun List<Int>.tail() = drop(1)

    private fun maximum1(items: List<Int>): Int {
        println(items)
        val result: Int = when {
            items.isEmpty() -> error("items is empty")
            items.size == 1 -> items.first()
            items.first() >= maximum1(items.tail()) -> items.first()
            // maximum을 2번 계산하는 낭비 발생
            else -> maximum1(items.tail())
        }
        return result
    }

    private fun maximum2(items: List<Int>): Int {
        println(items)
        val result: Int = when {
            items.isEmpty() -> error("items is empty")
            items.size == 1 -> items.first()
            else -> {
                val maxVal = maximum2(items.tail())
                if (items.first() > maxVal) items.first() else maxVal
            }
        }
        return result
    }

    @Test
    internal fun test() {
        assertThatThrownBy { maximum1(listOf()) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("items is empty")

        assertThat(maximum1(listOf(1))).isEqualTo(1)
        assertThat(maximum2(listOf(1, 3, 2, 8, 4))).isEqualTo(8)

    }
}