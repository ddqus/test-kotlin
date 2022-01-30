package oop

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestClass {
    @Test
    internal fun construct() {
        val user1 = User()
        assertThat(user1.name).isEqualTo("default")
        assertThat(user1.age).isEqualTo(999)

        val user2 = User(age = 2, name = "u2")
        assertThat(user2.name).isEqualTo("u2")
        assertThat(user2.age).isEqualTo(2)

        val user3 = User("u1", 11)
        assertThat(user3.name).isEqualTo("u1")
        assertThat(user3.age).isEqualTo(11)
    }

    @Test
    internal fun `readonly property`() {
        val user1 = User()
        assertThat(user1.name).isEqualTo("default")
        assertThat(user1.age).isEqualTo(999)

        user1.name = "changed"
        assertThat(user1.name).isEqualTo("changed")

        // val에 수정 시도시 컴파일 에러 발생
//        user1.age = 22
    }

    class User(
        var name: String = "default",
        val age: Int = 999
    )
}