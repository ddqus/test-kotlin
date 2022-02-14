package java_in_kotlin

import example.JavaInterface
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestJavaInterface {
    @Test
    internal fun test() {
        val impl = JavaInterfaceImpl()
        assertThat(impl.call()).isEqualTo("kotlin implement java interface")
        assertThat(impl is JavaInterface).isTrue
    }

    class JavaInterfaceImpl : JavaInterface {
        override fun call(): String {
            return "kotlin implement java interface"
        }
    }
}