package example.factorial

import org.junit.jupiter.params.provider.Arguments
import java.math.BigDecimal

class FactorialDataSource {
    companion object {
        @JvmStatic
        fun dataSource() = listOf(
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(3, 6),
            Arguments.of(4, 24),
        )

        @JvmStatic
        fun bigDecimalDataSource() = listOf(
            Arguments.of(BigDecimal("4"), BigDecimal("24")),
            Arguments.of(
                BigDecimal("100"),
                BigDecimal(
                    "93326215443944152681699238856266700490715968264381621468592963" +
                            "8952175999932299156089414639761565182862536979208272237582511852109168" +
                            "64000000000000000000000000"
                )
            ),
            // stackoverflow, 10000, 100000
//            Arguments.of(BigDecimal("100000"), BigDecimal("24")),
        )
    }
}