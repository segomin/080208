package com.fpinkotlin.recursion.exercise04

fun string(list: List<Char>): String {
    tailrec fun string_(list_: List<Char>, acc: String): String {
        return when {
            list_.isEmpty() -> acc
            else -> string_(list_.tail(), "${acc}${list_.head()}")
        }
    }

    return string_(list, "")
}
