package basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestLambda {
    private fun lambda1() = {
        0 + 1
    }

    private fun lambda2() = {
        0 + 1
        2 + 3
    }

    private fun lambda3() = {
        0 + 1
        2 + 3
        4 + 5
    }

    @Test
    internal fun `lambda return last result`() {
        assertThat(true).isTrue
        assertThat(lambda1()()).isEqualTo(1)
        assertThat(lambda2()()).isEqualTo(5)
        assertThat(lambda3()()).isEqualTo(9)
    }
}