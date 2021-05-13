package com.fpinkotlin.functions.exercise05


import com.fpinkotlin.functions.exercise01.higherCompose
import com.fpinkotlin.functions.exercise01.square
import com.fpinkotlin.functions.exercise01.triple
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FunctionsTest: StringSpec() {

    init {

// Uncomment after implementing the function
        "higherCompose" {
            forAll { x: Int ->
                higherCompose<Int, Int, Int>()(::square)(::triple)(x) == square(triple(x))
            }
        }
    }
}

