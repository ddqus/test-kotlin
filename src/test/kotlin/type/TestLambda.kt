package type

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestLambda {
    @Test
    internal fun `single line`() {
        val sum = { x: Int, y: Int -> x + y }
        assertThat(sum(2, 3)).isEqualTo(5)
    }

    @Test
    internal fun `multi line`() {
        val sum = { x: Int, y: Int ->
            x
            y
            x
        }
        assertThat(sum(2, 3)).isEqualTo(2)
    }

    @Test
    internal fun `multi line with outside type definition`() {
        val sum: (Int, Int) -> Int = { x, y ->
            x
            y
        }
        assertThat(sum(2, 3)).isEqualTo(3)
    }

    @Test
    internal fun `if else with single line`() {
        val min = { x: Int, y: Int -> if (x > y) y else x }
        assertThat(min(2, 3)).isEqualTo(2)
    }
}