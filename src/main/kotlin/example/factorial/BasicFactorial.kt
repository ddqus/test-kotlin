package example.factorial

import java.math.BigDecimal

class BasicFactorial : Factorial {
    override fun calc(n: Int): Int = calc(BigDecimal((n))).toInt()

    override fun calc(n: BigDecimal): BigDecimal {
        val result = when {
            n <= BigDecimal.ONE -> BigDecimal.ONE
            else -> {
                n * calc(n - BigDecimal.ONE)
            }
        }
        return result
    }
}
