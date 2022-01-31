package junit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TestParameterized {
    @ParameterizedTest
    @MethodSource("equalSource")
    internal fun `is equal`(expected: Int, actual: Int) {
        assertThat(expected).isEqualTo(actual)
    }

//    @ParameterizedTest
//    @MethodSource("instanceSource")
//    internal fun `failed instance`(expected: Any, actual: Class<*>) {
//        assertThat(expected).isNotInstanceOf(actual)
//    }
//
//    @ParameterizedTest
//    @MethodSource("instanceSource")
//    internal fun `is instance using class_dot_java`(expected: Any, actual: Class<*>) {
//        assertThat(expected::class.java).isEqualTo(actual)
//    }

    companion object {
        @JvmStatic
        fun equalSource() = listOf(
            Arguments.of(1, 1),
            Arguments.of(2, 2),
        )

//        @JvmStatic
//        fun instanceSource() = listOf(
//            Arguments.of(1, Int::class.java),
//            Arguments.of("s", 2),
//        )
    }
}
