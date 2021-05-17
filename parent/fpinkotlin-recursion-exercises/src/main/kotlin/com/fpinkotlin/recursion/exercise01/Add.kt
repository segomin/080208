package com.fpinkotlin.recursion.exercise01


tailrec fun add(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    } else if (b < 0) {
        return add(dec(a), inc(b))
    }
    return add(inc(a), dec(b))
}

fun inc(n: Int) = n + 1
fun dec(n: Int) = n - 1

