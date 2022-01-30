package control

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestFor {
    @Test
    internal fun `for in`() {
        var validator = ""
        val collection = listOf(1, 2, 3)
        assertThat(collection).isNotEmpty

        assertThat(validator).isEqualTo("")
        for (item in collection) {
            validator += item
        }
        assertThat(validator).isEqualTo("123")
    }

    @Test
    internal fun `for withIndex`() {
        var validator = ""
        val collection = listOf(1, 2, 3)

        assertThat(validator).isEqualTo("")
        for ((index, item) in collection.withIndex()) {
            // TODO string + $ 사용법
            validator += "[$index]$item"
        }
        assertThat(validator).isNotEmpty
        assertThat(validator).isEqualTo("[0]1[1]2[2]3")
    }

    @Test
    internal fun `for with range`() {
        var validator = ""
        assertThat(validator).isEqualTo("")
        for(i in 1..3){
            validator += i
        }

        assertThat(validator).isNotEmpty
        assertThat(validator).isEqualTo("123")
    }

    @Test
    internal fun `for until`() {
        var validator = ""
        assertThat(validator).isEqualTo("")
        for(i in 1 until 3){
            validator += i
        }

        assertThat(validator).isNotEmpty
        assertThat(validator).isEqualTo("12")
    }

    @Test
    internal fun `for downto`() {
        var validator = ""
        assertThat(validator).isEqualTo("")
        for(i in 6 downTo 0){
            validator += i
        }

        assertThat(validator).isNotEmpty
        assertThat(validator).isEqualTo("6543210")
    }

    @Test
    internal fun `for downto step`() {
        var validator = ""
        assertThat(validator).isEqualTo("")
        for(i in 6 downTo 0 step 2){
            validator += i
        }

        assertThat(validator).isNotEmpty
        assertThat(validator).isEqualTo("6420")
    }
}