package example.powerset

class BasicPowerset<T> : Powerset<T> {
    private fun Set<T>.tail() = drop(1).toSet()

    override fun calc(s: Set<T>): Set<Set<T>> {
        val result = when {
            s.isEmpty() -> setOf(setOf())
            else -> {
                val rest = calc(s.tail())
                rest + rest.map { setOf(s.first()) + it }.toSet()
            }
        }
        return result
    }
}
