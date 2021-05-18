package com.fpinkotlin.recursion.exercise10


fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    val list = mutableListOf<T>()
    var x = seed
    while(p(x)) {
        list.add(x)
        x = f(x)
    }
    return list
}

