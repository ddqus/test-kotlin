package example.powerset

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BasicPowersetTest {
//    private val powerset: Powerset<Int> = BasicPowerset()
    private val powerset: Powerset<Int> = RecursionPowerset()

    @Test
    internal fun instance() {
        assertThat(powerset).isNotNull
    }

    @Test
    internal fun powerset() {
        assertThat(powerset.calc(setOf(1, 2, 3))).isEqualTo(
            setOf(
                setOf(),
                setOf(1),
                setOf(2),
                setOf(3),
                setOf(1, 2),
                setOf(1, 3),
                setOf(2, 3),
                setOf(1, 2, 3),
            )
        )
    }
}