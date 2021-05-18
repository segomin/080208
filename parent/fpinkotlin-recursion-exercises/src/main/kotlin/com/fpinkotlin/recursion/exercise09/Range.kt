package com.fpinkotlin.recursion.exercise09


fun range(start: Int, end: Int): List<Int> {
    val list = mutableListOf<Int>()
    var idx = start
    while(idx < end) {
        list.add(idx)
        idx++
    }
    return list
}