package example.factorial

class BasicFactorial : Factorial {
    override fun calc(n: Int): Int {
        val result = when {
            n <= 1 -> 1
            else -> {
                n * calc(n - 1)
            }
        }
        return result
    }
}
