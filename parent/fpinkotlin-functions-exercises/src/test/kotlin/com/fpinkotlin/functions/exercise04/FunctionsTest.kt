package com.fpinkotlin.functions.exercise04


import com.fpinkotlin.functions.exercise01.compose
import com.fpinkotlin.functions.exercise01.square
import com.fpinkotlin.functions.exercise01.triple
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FunctionsTest: StringSpec() {

    init {


// Uncomment after implementing the function
        "compose" {
            forAll { x: Int ->
                compose(::square)(::triple)(x) == square(triple(x))
            }
        }
    }
}

