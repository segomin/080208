package com.fpinkotlin.recursion.exercise15

import java.math.BigInteger


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

fun fibo(number: Int): String {
    tailrec fun fibo_(acc: List<BigInteger>, b1: BigInteger, b2: BigInteger, x: Int): List<BigInteger> {
        if (x == number) {
            return acc
        }
        return when (x) {
            0 -> fibo_(acc + 1.toBigInteger(), BigInteger.ZERO, BigInteger.ONE, x + 1)
            1 -> fibo_(acc + 1.toBigInteger(), BigInteger.ONE, BigInteger.ONE, x + 1)
            else -> {
                val sum = b1 + b2
                fibo_(acc + sum, b2, sum, x + 1)
            }
        }
    }

    val list = fibo_(listOf(), BigInteger.ZERO, BigInteger.ZERO, 0)
    return makeString(list, ",")
}

fun <T> makeString(list: List<T>, separator: String): String =
    when {
        list.isEmpty() -> ""
        list.tail().isEmpty() -> "${list.head()}"
        else -> foldLeft(list.tail(), "${list.head()}") { acc, x -> "${acc}${separator}${x}" }
    }

