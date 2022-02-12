package clazz

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestAbcClass {
    @Test
    internal fun instance() {
        val child = Child()
        assertThat(child).isInstanceOf(Parent::class.java)
        assertThat(child.parent()).isEqualTo("parent")
    }

    abstract class Parent {
        fun parent(): String {
            return "parent"
        }
    }

    class Child : Parent() {}
}