package exception

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class TestException {
    @Test
    internal fun `catch exception`() {
        Assertions.assertThatThrownBy { 5 / 0 }
            .isInstanceOf(ArithmeticException::class.java)
            .hasMessage("/ by zero")
    }
}