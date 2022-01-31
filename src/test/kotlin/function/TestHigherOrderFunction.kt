package function

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestHigherOrderFunction {
    private fun higherOrderFunction(): () -> Unit {
        return {}
    }

    @Test
    internal fun test() {
        val function = higherOrderFunction()
        assertThat(function()).isInstanceOf(Unit::class.java)
    }
}