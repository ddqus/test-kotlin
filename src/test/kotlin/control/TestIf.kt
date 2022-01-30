package control

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestIf {
    private fun max(x: Int, y: Int) = if (x > y) x else y

    @Test
    internal fun `use if as expression`() {
        assertThat(max(1, 2)).isEqualTo(2)
        assertThat(max(3, 1)).isEqualTo(3)
    }

    @Test
    internal fun `if need else when expression`() {
        val v1 = if (1 > 2) 2 else 3
        assertThat(v1).isEqualTo(3)
        // else가 없으면 컴파일 에러가 발생한다
//        val v2 = if (1 > 2) 2
    }
}