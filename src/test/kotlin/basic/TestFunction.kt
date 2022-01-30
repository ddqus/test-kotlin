package basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestFunction {

    private fun twice1(value: Int): Int {
        return value * 2
    }

    @Test
    internal fun `function with code block and return`() {
        assertThat(twice1(2)).isEqualTo(4)
        assertThat(twice1(3)).isEqualTo(6)
    }

    private fun twice2(value: Int): Int = value * 2

    @Test
    internal fun `function with inline`() {
        assertThat(twice2(2)).isEqualTo(4)
        assertThat(twice2(3)).isEqualTo(6)
    }

    private fun twice3(value: Int) = value * 2

    @Test
    internal fun `function with inference`() {
        assertThat(twice3(2)).isEqualTo(4)
        assertThat(twice3(3)).isEqualTo(6)
    }

    private fun addWithDefault(x: Int = 10, y: Int = 3) = x + y

    @Test
    internal fun `function with default value`() {
        assertThat(addWithDefault()).isEqualTo(13)
        assertThat(addWithDefault(1)).isEqualTo(4)
        assertThat(addWithDefault(1, 2)).isEqualTo(3)

        assertThat(addWithDefault(y = 7)).isEqualTo(17)
        assertThat(addWithDefault(y = 7, x = 1)).isEqualTo(8)
    }

    private fun sum(x: Int, y: Int, calculate: (Int, Int) -> Int) = calculate(x, y)

    @Test
    internal fun `test anonymous function`() {
        assertThat(sum(1, 2, { x, y -> x + y })).isEqualTo(3)
        assertThat(sum(4, 5, { x, y -> x + y })).isEqualTo(9)
    }
}