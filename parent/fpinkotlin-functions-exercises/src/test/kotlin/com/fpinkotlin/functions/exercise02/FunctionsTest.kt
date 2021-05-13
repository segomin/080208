package com.fpinkotlin.functions.exercise02


import com.fpinkotlin.functions.exercise01.*
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FunctionsTest: StringSpec() {

    init {
// Uncomment after implementing the function
        "compose" {
            forAll { x: Int ->
                compose(::square, ::triple)(x) == square(triple(x))
            }
        }
    }

}

