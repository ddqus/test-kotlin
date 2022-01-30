package control

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestWhen {
    private fun whenAsValue(x: Int): String {
        var result = "init"

        when (x) {
            1 -> result = "is 1"
            2, 3 -> result = "2 or 3"
            else -> result = "else"
        }
        return result
    }

    @Test
    internal fun `use when as value`() {
        assertThat(whenAsValue(1)).isEqualTo("is 1")
        assertThat(whenAsValue(2)).isEqualTo("2 or 3")
        assertThat(whenAsValue(3)).isEqualTo("2 or 3")
        assertThat(whenAsValue(4)).isEqualTo("else")
    }

    private fun whenAsExpression(x: Int): String {
        // else 키워드가 있어야 expression 으로 평가된다
        return when {
            x == 0 -> "zero"
            x > 0 -> "positive"
            else -> "negative"
        }
    }

    @Test
    internal fun `use when as expression`() {
        assertThat(whenAsExpression(0)).isEqualTo("zero")
        assertThat(whenAsExpression(1)).isEqualTo("positive")
        assertThat(whenAsExpression(-1)).isEqualTo("negative")
    }
}
