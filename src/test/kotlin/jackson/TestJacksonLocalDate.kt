package jackson

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TestJacksonLocalDate {
    @Test
    internal fun `default is fail`() {
        val mapper = jacksonObjectMapper()
        val parent = Parent(LocalDateTime.now())

        assertThatThrownBy { mapper.writeValueAsString(parent) }
            .isInstanceOf(InvalidDefinitionException::class.java)
            .hasMessageStartingWith("Java 8 date/time type `java.time.LocalDateTime` not supported by default")
    }

    @Test
    internal fun `success if registerModule`() {
        val mapper = jacksonObjectMapper()
        mapper.registerModule(JavaTimeModule())
        val parent = Parent(LocalDateTime.of(2001, 2, 3, 4, 5, 6))

        assertThat(mapper.writeValueAsString(parent))
            .isEqualTo("{\"createdAt\":[2001,2,3,4,5,6]}")
    }

    @JsonAutoDetect(
        fieldVisibility = Visibility.ANY,
        getterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE
    )
    private class Parent(
        private val createdAt: LocalDateTime,
    )
}