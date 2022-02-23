package jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestJackson {
    private val mapper: ObjectMapper = jacksonObjectMapper()

    @Test
    internal fun setup() {
        assertThat(mapper).isNotNull
    }

    @Test
    internal fun `no getter setter`() {
        val sut = NoGetterSetter(1L)
        assertThat(mapper.writeValueAsString(sut))
            .isEqualTo("{}")
    }

    @Test
    internal fun `only getter`() {
        val sut = OnlyGetter(1L)
        assertThat(mapper.writeValueAsString(sut))
            .isEqualTo("{\"id\":1}")
    }

    @Test
    internal fun `getter without get`() {
        val sut = GetterWithoutGet(2L)
        assertThat(mapper.writeValueAsString(sut))
            .isEqualTo("{}")
    }

    @Test
    internal fun `getter and setter`() {
        val sut = GetterAndSetter(3L)
        assertThat(mapper.writeValueAsString(sut))
            .isEqualTo("{\"id\":3}")
    }

    private class NoGetterSetter(
        private var id: Long,
    )

    private class OnlyGetter(
        private var id: Long,
    ) {
        fun getId(): Long {
            return id
        }
    }

    private class GetterWithoutGet(
        private var id: Long,
    ) {
        fun id(): Long {
            return id
        }
    }

    private class GetterAndSetter(
        private var id: Long,
    ) {
        fun getId(): Long {
            return id
        }

        fun setId(id: Long) {
            this.id = id
        }
    }
}