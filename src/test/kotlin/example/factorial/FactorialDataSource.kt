package example.factorial

import org.junit.jupiter.params.provider.Arguments

class FactorialDataSource {
    companion object {
        @JvmStatic
        fun dataSource() = listOf(
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(3, 6),
            Arguments.of(4, 24),
        )
    }
}