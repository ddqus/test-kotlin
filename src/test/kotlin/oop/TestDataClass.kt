package oop

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestDataClass {
    @Test
    internal fun `value type of class is not equal`() {
        val user1 = User()
        val user2 = User()
        assertThat(user1.name).isEqualTo("default")
        assertThat(user1.age).isEqualTo(999)
        assertThat(user2.name).isEqualTo("default")
        assertThat(user2.age).isEqualTo(999)
        assertThat(user1).isNotEqualTo(user2)
        assertThat(user1 == user2).isFalse()
    }

    @Test
    internal fun `value type of data class is equal`() {
        val datauser1 = DataUser()
        val datauser2 = DataUser()
        assertThat(datauser1.name).isEqualTo("default")
        assertThat(datauser1.age).isEqualTo(999)
        assertThat(datauser2.name).isEqualTo("default")
        assertThat(datauser2.age).isEqualTo(999)
        assertThat(datauser1).isEqualTo(datauser2)
        assertThat(datauser1 == datauser2).isTrue()
    }

    data class DataUser(
        var name: String = "default",
        val age: Int = 999
    )

    class User(
        var name: String = "default",
        val age: Int = 999
    )
}