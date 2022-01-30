package type

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestInstance {
    @Test
    internal fun `what is java instance`() {
        /**
         * The resulting type of this 'javaClass' call is Class<String.Companion> and not Class<String>.
         * Please use the more clear '::class.java' syntax to avoid confusion
         */
        assertThat("string").isNotInstanceOf(String.javaClass)
    }

    @Test
    internal fun `access class using class_dot_java`() {
        assertThat("string").isInstanceOf(String::class.java)
    }
}
