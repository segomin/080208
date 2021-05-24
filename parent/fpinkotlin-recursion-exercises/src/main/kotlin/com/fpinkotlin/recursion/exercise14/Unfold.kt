package com.fpinkotlin.recursion.exercise14


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

fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    tailrec fun unfold_(acc: List<T>, elem: T): List<T> =
        if (p(elem))
            unfold_(acc + elem, f(seed))
        else
            acc

    return unfold_(listOf(), seed)
}
//fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
//    val list = mutableListOf<T>()
//    var elem = seed;
//    while (p(elem)) {
//        list.add(elem)
//        elem = f(elem)
//    }
//    return list.toList()
//}
