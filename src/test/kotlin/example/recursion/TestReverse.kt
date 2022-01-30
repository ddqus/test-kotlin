package example.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestReverse {
    private fun String.tail() = drop(1)

    private fun reverse(str: String): String {
        val result: String = when {
            str.isEmpty() -> ""
            else -> reverse(str.tail()) + str.first()
        }
        return result
    }

    @Test
    internal fun test() {
        assertThat(reverse("")).isEqualTo("")
        assertThat(reverse("qwerty")).isEqualTo("ytrewq")
        assertThat(reverse("123456")).isEqualTo("654321")
    }
}