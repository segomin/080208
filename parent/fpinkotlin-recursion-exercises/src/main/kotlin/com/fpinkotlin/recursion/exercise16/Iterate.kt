package com.fpinkotlin.recursion.exercise16


fun <T> iterate(seed: T, f: (T) -> T, n: Int): List<T> {
    tailrec fun iter_(acc: List<T>, x: T): List<T> {
        return if (acc.size < n) iter_(acc + x, f(x))
        else acc
    }

    return iter_(listOf(), seed);
}