package example.factorial

import example.Bounce
import example.Done
import example.More
import example.trampoline
import java.math.BigDecimal

class TrampolineFactorial : Factorial {
    override fun calc(n: Int): Int = calc(BigDecimal((n))).toInt()

    override fun calc(n: BigDecimal): BigDecimal = trampoline(calcTrampoline(n))

    private fun calcTrampoline(n: BigDecimal, carry: BigDecimal = BigDecimal.ONE): Bounce<BigDecimal> {
        val result = when (n) {
            BigDecimal.ZERO -> Done(BigDecimal.ONE)
            BigDecimal.ONE -> Done(carry)
            else -> {
                More {
                    calcTrampoline(
                        n - BigDecimal.ONE,
                        n * carry
                    )
                }
            }
        }
        return result
    }
}