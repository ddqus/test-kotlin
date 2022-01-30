package oop

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestInterface {
    @Test
    internal fun `instance type`() {
        val kotlin = Kotlin()
        assertThat(kotlin).isInstanceOf(Kotlin::class.java)
        assertThat(kotlin).isInstanceOf(Foo::class.java)
        assertThat(kotlin).isInstanceOf(Bar::class.java)
    }

    @Test
    internal fun override() {
        val kotlin = Kotlin()
        assertThat(kotlin.printFoo()).isEqualTo("foo")
        assertThat(kotlin.printBar()).isEqualTo("bar")
        assertThat(kotlin.printKotlin()).isEqualTo("fookotbarkot")
    }
}

interface Foo {
    fun printFoo() = "foo"
    fun printKotlin() = "fookot"
}

interface Bar {
    fun printBar() = "bar"
    fun printKotlin() = "barkot"
}

class Kotlin : Foo, Bar {
    override fun printKotlin() = super<Foo>.printKotlin() + super<Bar>.printKotlin()
}
