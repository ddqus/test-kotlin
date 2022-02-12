package clazz

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestClassProperty {
    @Test
    internal fun test() {
        val parent = Parent()
        assertThat(parent.p1()).isEqualTo("p1val")
    }

    class Parent {
        private val p1: String = "p1val"

        fun p1(): String {
            return p1
        }
    }
}