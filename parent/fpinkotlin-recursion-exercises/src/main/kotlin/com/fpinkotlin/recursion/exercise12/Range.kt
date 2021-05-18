package com.fpinkotlin.recursion.exercise12


fun <T> List<T>.head(): T =
    if (this.isEmpty())
        throw IllegalArgumentException("head called on empty list")
    else
        this[0]

fun <T> List<T>.tail(): List<T> =
    if (this.isEmpty())
        throw IllegalArgumentException("tail called on empty list")
    else
        this.subList(1, this.size)

fun <T, U> foldLeft(list: List<T>, z: U, f: (U, T) -> U): U {
    tailrec fun foldLeft_(list: List<T>, acc: U, f: (U, T) -> U): U =
        if (list.isEmpty())
            acc
        else
            foldLeft_(list.tail(), f(acc, list.head()), f)
    return foldLeft_(list, z, f)
}

fun <T> prepend(list: List<T>, elem: T): List<T> = foldLeft(list, listOf(elem)) { lst, elm -> lst + elm }

fun range(start: Int, end: Int): List<Int> {
    return if (end <= start) listOf()
    else prepend(range(start + 1, end), start)
}