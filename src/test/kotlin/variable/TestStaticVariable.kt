package variable

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestStaticVariable {
    companion object {
        const val valueInt = 10
        const val valueStr = "static value"

        //Only primitives and String are allowed
        //const val valueList: List<String> = ArrayList()
        val valueList: List<String> = ArrayList()
    }

    @Test
    internal fun test() {
        assertThat(valueInt).isEqualTo(10)
        assertThat(valueStr).isEqualTo("static value")
        assertThat(valueList.size).isEqualTo(0)
        valueList
    }
}
