package com.fpinkotlin.recursion.exercise04

fun <T> makeString(list: List<T>, delim: String): String {

    tailrec fun sum(tail: List<T>, acc: String): String {
        return when {
            tail.isEmpty() -> acc
//            acc.isEmpty() -> sum(tail.tail(), "${tail.head()}") since test has empty string
            else -> sum(tail.tail(), "${acc}${delim}${tail.head()}")
        }
    }
    return when {
        list.isEmpty() -> ""
        list.size == 1 -> "${list.head()}"
        else -> sum(list.tail(), "${list.head()}")
    }
}

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
