package example.powerset

class RecursionPowerset<T> : Powerset<T> {

    override fun calc(s: Set<T>): Set<Set<T>> = calcRec(s)

    private fun Set<T>.tail() = drop(1).toSet()
    private tailrec fun calcRec(s: Set<T>, carry: Set<Set<T>> = setOf(setOf())): Set<Set<T>> {
        return when {
            s.isEmpty() -> carry
            else -> calcRec(
                s.tail(),
                carry + carry.map { it + s.first() }
            )
        }
    }
}