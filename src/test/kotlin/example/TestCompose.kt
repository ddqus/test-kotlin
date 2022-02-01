package example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestCompose {
    private infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
        return { gInput: G -> this(g(gInput)) }
    }

    @Test
    internal fun test() {
        val twice = { i: Int -> i * 2 }
        val addThree = { i: Int -> i + 3 }
        val composed = addThree compose twice
        assertThat(composed(3)).isEqualTo(9)
    }

    private fun List<Int>.tail() = drop(1)

    private tailrec fun max(items: List<Int>, carry: Int = Int.MIN_VALUE): Int = when {
        items.isEmpty() -> carry
        else -> max(items.tail(), if (items.first() > carry) items.first() else carry)
    }

    @Test
    internal fun `max and power`() {
        val maxFunc = { items: List<Int> -> max(items) }
        assertThat(maxFunc(listOf(1, 4, 6))).isEqualTo(6)

        val power = { x: Int -> x * x }
        assertThat(power(3)).isEqualTo(9)
        assertThat(power(4)).isEqualTo(16)

        val composeManually = { nums: List<Int> -> power(max(nums)) }
        assertThat(composeManually(listOf(1, 4, 6))).isEqualTo(36)

        val composed = power compose maxFunc
        assertThat(composed(listOf(1, 4, 6))).isEqualTo(36)
    }

    private tailrec fun power(x: Double, n: Int, carry: Double = 1.0): Double = when {
        n <= 0 -> carry
        else -> power(x, n - 1, x * carry)
    }

    private tailrec fun gcd(left: Int, right: Int): Int = when {
        right == 0 -> left
        else -> gcd(right, right % left)
    }

    @Test
    internal fun `power and gcd with manually`() {
        val powerOfTwo = { x: Int -> power(x.toDouble(), 2).toInt() }
        assertThat(powerOfTwo(2)).isEqualTo(4)
        assertThat(powerOfTwo(3)).isEqualTo(9)

        val gcdPowerOfTwo = { left: Int, right: Int -> gcd(powerOfTwo(left), powerOfTwo(right)) }
        assertThat(gcdPowerOfTwo(2, 3)).isEqualTo(1)
        assertThat(gcdPowerOfTwo(4, 6)).isEqualTo(4)
    }
}
