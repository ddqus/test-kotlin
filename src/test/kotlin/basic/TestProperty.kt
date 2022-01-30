package basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestProperty {
    @Test
    internal fun `readonly property`() {
        val value: Int = 10
        assertThat(value).isEqualTo(10)

        // write를 시도하면 컴파일 에러 발생
//        value = 20
    }

    @Test
    internal fun `writable property`() {
        var value: Int = 10
        assertThat(value).isEqualTo(10)

        value = 20
        assertThat(value).isEqualTo(20)
    }

    @Test
    internal fun `null safety property`() {
        // null을 할당하면 컴파일 에러 발생
//        var value: Int = null
        var value: Int? = null
        assertThat(value).isEqualTo(null)
    }
}
