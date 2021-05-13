package com.fpinkotlin.functions.exercise01

fun square(n: Int) = n * n

fun triple(n: Int) = n * 3

// by compose(::square, ::triple)(x) == square(triple(x))
fun <T, U, V>compose(f: (U) -> V, g: (T) -> U): (T) -> V  = { f(g(it)) }

// by compose(::square)(::triple)(x) == square(triple(x))
fun <T, V>compose(f: (T) -> V): ((T) -> T) -> ((T) -> V) = { g ->
    { x -> f(g(x)) }
}

// by higherCompose<Int, Int, Int>()(::square)(::triple)(x) == square(triple(x))
fun <T, U, V> higherCompose(): ((T) -> V) -> ((U) -> T) -> ((U) -> V) = { f ->
    { g ->
        { x ->
            f(g(x))
        }
    }
}

// by add(x)(y) == x + y
fun add(x: Int): (y: Int) -> Int = {
    x + it
}
