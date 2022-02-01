package example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PartialApplyFunction3Test {
    private fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial1(p1: P1): (P2, P3) -> R {
        return { p2, p3 -> this(p1, p2, p3) }
    }

    private fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial2(p2: P2): (P1, P3) -> R {
        return { p1, p3 -> this(p1, p2, p3) }
    }

    private fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial3(p3: P3): (P1, P2) -> R {
        return { p1, p2 -> this(p1, p2, p3) }
    }

    @Test
    internal fun test() {
        val func = { p1: String, p2: String, p3: String -> p1 + p2 + p3 }

        val partial1 = func.partial1("p1")
        assertThat(partial1("p2", "p3")).isEqualTo("p1p2p3")

        val partial2 = func.partial2("p1")
        assertThat(partial2("p2", "p3")).isEqualTo("p2p1p3")

        val partial3 = func.partial3("p1")
        assertThat(partial3("p2", "p3")).isEqualTo("p2p3p1")
    }
}