package com.fpinkotlin.recursion.exercise11


fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    val result: MutableList<T> = mutableListOf()
    var elem = seed
    while (p(elem)) {
        result.add(elem)
        elem = f(elem)
    }
    return result
}

fun range(start: Int, end: Int): List<Int> = unfold(start, {x -> x + 1}, {x -> x < end})