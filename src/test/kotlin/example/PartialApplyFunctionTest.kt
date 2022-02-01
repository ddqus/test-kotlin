package example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PartialApplyFunctionTest {
    private fun <P1, P2, R> ((P1, P2) -> R).partial1(p1: P1): (P2) -> R {
        return { p2 -> this(p1, p2) }
    }

    private fun <P1, P2, R> ((P1, P2) -> R).partial2(p2: P2): (P1) -> R {
        return { p1 -> this(p1, p2) }
    }

    @Test
    internal fun test() {
        val func = { p1: String, p2: String -> p1 + p2 }

        val partiallyAppliedFunc1 = func.partial1("Hello")
        assertThat(partiallyAppliedFunc1("World")).isEqualTo("HelloWorld")

        val partiallyAppliedFunc2 = func.partial2("World")
        assertThat(partiallyAppliedFunc2("Hello")).isEqualTo("HelloWorld")
    }
}