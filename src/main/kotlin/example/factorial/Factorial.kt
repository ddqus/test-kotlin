package example.factorial

import java.math.BigDecimal

interface Factorial {
    fun calc(n: Int): Int

    fun calc(n: BigDecimal): BigDecimal
}
