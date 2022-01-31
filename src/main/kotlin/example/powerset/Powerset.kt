package example.powerset

interface Powerset<T> {
    fun calc(s: Set<T>): Set<Set<T>>
}
