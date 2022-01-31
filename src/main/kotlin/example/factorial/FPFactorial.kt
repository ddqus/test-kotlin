package example.factorial

import java.math.BigDecimal

class FPFactorial : Factorial {
    override fun calc(n: Int): Int = calc(BigDecimal((n))).toInt()

    override fun calc(n: BigDecimal) = calcFP(n)

    private fun calcFP(n: BigDecimal, carry: BigDecimal = BigDecimal.ONE): BigDecimal {
        val result = when (n) {
            BigDecimal.ZERO -> BigDecimal.ONE
            BigDecimal.ONE -> carry
            else -> {
                calcFP(n - BigDecimal.ONE, n * carry)
            }
        }
        return result
    }
}