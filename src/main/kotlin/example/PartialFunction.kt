package example

class PartialFunction<in P, out R>(
    private val condition: (P) -> Boolean,
    private val f: (P) -> R
) : (P) -> R {

    override fun invoke(p: P): R {
        val result = when {
            condition(p) -> f(p)
            else -> throw IllegalArgumentException("$p isn't supported")
        }
        return result
    }

    fun isDefinedAt(p: P): Boolean = condition(p)
}