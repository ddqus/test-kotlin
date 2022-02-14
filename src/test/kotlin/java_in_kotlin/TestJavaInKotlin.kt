package java_in_kotlin

import example.JavaInKotlin
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestJavaInKotlin {
    @Test
    internal fun test() {
        assertThat(JavaInKotlin.dump()).isEqualTo("java in kotlin")
    }
}