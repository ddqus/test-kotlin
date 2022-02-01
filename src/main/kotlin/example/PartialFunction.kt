package example

class PartialFunction<P, R>(
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

    fun invokeOrElse(p: P, default: R): R = when {
        isDefinedAt(p) -> invoke(p)
        else -> default
    }

    fun orElse(that: PartialFunction<P, R>): PartialFunction<P, R> {
        val func = PartialFunction(
            { value: P -> this.isDefinedAt(value) || that.isDefinedAt(value) },
            { value: P ->
                when {
                    this.isDefinedAt(value) -> this(value)
                    that.isDefinedAt(value) -> that(value)
                    else -> throw IllegalArgumentException("$value isn't defined")
                }
            }
        )
        return func
    }
}