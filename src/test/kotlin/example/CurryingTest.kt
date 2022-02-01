package example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CurryingTest {
    private fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curried()
            : (P1) -> (P2) -> (P3) -> R =
        { p1: P1 -> { p2: P2 -> { p3: P3 -> this(p1, p2, p3) } } }

    private fun <P1, P2, P3, R> ((P1) -> (P2) -> (P3) -> R).uncurried()
            : (P1, P2, P3) -> R =
        { p1: P1, p2: P2, p3: P3 -> this(p1)(p2)(p3) }

    @Test
    internal fun test() {
        val multiThree = { a: Int, b: Int, c: Int -> a * b * c }
        val curried = multiThree.curried()
        assertThat(curried(2)(3)(4)).isEqualTo(24)

        val uncurried = curried.uncurried()
        assertThat(uncurried(1, 2, 3)).isEqualTo(6)
    }

    private fun <P1, P2, R> ((P1, P2) -> R).curried()
            : (P1) -> (P2) -> R =
        { p1: P1 -> { p2: P2 -> this(p1, p2) } }

    @Test
    internal fun `min using currying`() {
        val min = { a: Int, b: Int -> if (a > b) b else a }
        val curried = min.curried()
        assertThat(curried(2)(3)).isEqualTo(2)
        assertThat(curried(4)(3)).isEqualTo(3)
    }
}