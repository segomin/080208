package com.fpinkotlin.functions.exercise06


import com.fpinkotlin.functions.exercise01.higherAndThen
import com.fpinkotlin.functions.exercise01.square
import com.fpinkotlin.functions.exercise01.triple
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FunctionsTest: StringSpec() {

    init {

        "higherAndThen" {
            forAll { x: Int ->
                higherAndThen<Int, Int, Int>()(::square)(::triple)(x) == triple(square(x))
            }
        }
    }
}

