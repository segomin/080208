package com.fpinkotlin.recursion.exercise09


import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class RangeTest : StringSpec() {

    init {

        "range" {
            forAll(Gen.choose(0, 10_000), Gen.choose(0, 10_000)) { a: Int, b: Int ->
                range(a, b) == (a until b).toList()
            }
        }
    }
}