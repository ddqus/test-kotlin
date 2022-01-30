package basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestMethodNaming {
    @Test
    internal fun `only english`() {
        assertThat(true).isTrue
    }

    @Test
    internal fun `한글도 되나`() {
        assertThat(true).isTrue
    }

    @Test
    internal fun `가능한 특수문자 1234567890-= ~!@#$%^&*()_+`() {
        assertThat(true).isTrue
    }

    @Test
    internal fun `가능한 특수문자 {}|'",?`() {
        assertThat(true).isTrue
    }

//    @Test
//    internal fun `불가능한 특수문자 []\;:./<>`() {
//        assertThat(true).isTrue
//    }
}
