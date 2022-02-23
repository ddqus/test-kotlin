package jackson

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class TestJacksonProperty {
    /**
     * @JsonAutoDetect는 abc 클래스에 적용하면 자식에게도 적용된다
     */
    @Test
    internal fun test() {
        val mapper = jacksonObjectMapper()

        val child = Child(2)
        Assertions.assertThat(mapper.writeValueAsString(child))
            .isEqualTo("{\"childId\":2,\"parentId\":2}")
    }

    @JsonAutoDetect(
        fieldVisibility = Visibility.ANY,
        getterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE
    )
    private abstract class Parent(
        private val parentId: Int,
    )

    private class Child(
        childId: Int,
    ) : Parent(childId)
}
