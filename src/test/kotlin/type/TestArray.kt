package type

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestArray {
    @Test
    internal fun basic() {
        val array = Array(3, {})
        assertThat(array.size).isEqualTo(3)
    }

    @Test
    internal fun `initial value is Unit`() {
        val array = Array(3, {})
        assertThat(array.get(0)).isEqualTo(Unit)
        assertThat(array.get(0)).isNotInstanceOf(Int::class.java)
    }

    @Test
    internal fun `define initial value`() {
        val array = Array(3, {11})
        assertThat(array.get(0)).isEqualTo(11)
        assertThat(array.get(1)).isEqualTo(11)
        assertThat(array.get(2)).isEqualTo(11)
        // TODO test Int vs Integer
        // Int 여야 하지 않나? 왜 not 이지?
        assertThat(array.get(0)).isNotInstanceOf(Int::class.java)
    }

    @Test
    internal fun `negative initial value`() {
        val array = Array(3, {-2})
        assertThat(array.get(0)).isEqualTo(-2)
        assertThat(array.get(1)).isEqualTo(-2)
        assertThat(array.get(2)).isEqualTo(-2)
    }
}