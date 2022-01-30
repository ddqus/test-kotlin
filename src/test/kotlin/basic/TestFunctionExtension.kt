package basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestFunctionExtension {
    private fun Int.produce(value: Int) = this * value

    @Test
    internal fun `extension function`() {
        assertThat(10.produce(2)).isEqualTo(20)
    }

    private fun String.suffix(suffix: String) = String.format("Hello, %s", suffix)

    @Test
    internal fun `extension string`() {
        assertThat("".suffix("World")).isEqualTo("Hello, World")
        assertThat("".suffix("Kotlin")).isEqualTo("Hello, Kotlin")
    }
}
