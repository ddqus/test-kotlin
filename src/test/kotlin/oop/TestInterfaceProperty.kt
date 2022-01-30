package oop

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestInterfaceProperty {

    @Test
    internal fun `abstract property`() {
        val kotlin = Kotlin()
        assertThat(kotlin).isInstanceOf(Foo::class.java)
        assertThat(kotlin.bar).isEqualTo(3)
    }

    interface Foo {
        val bar: Int
    }

    class Kotlin: Foo {
        override val bar: Int = 3
    }
}
