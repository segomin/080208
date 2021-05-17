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
// fun <T, U, V> higherCompose(): ((U) -> V) -> ((T) -> U) -> ((T) -> V) = { f ->
fun <T, U, V> higherCompose() = { f: (U) -> V ->
    { g: (T) -> U ->
        { x: T -> f(g(x)) }
    }
}

// by add(x)(y) == x + y
fun add(x: Int): (y: Int) -> Int = {
    x + it
}

// higherAndThen<Int, Int, Int>()(::square)(::triple)(x) == triple(square(x))
// fun <T, U, V> higherAndThen(): ((T) -> U) -> ((U) -> V) -> ((T) -> V) = { g ->
fun <T, U, V> higherAndThen() = { g: (T) -> U ->
    { f: (U) -> V ->
        { x: T -> f(g(x)) }
    }
}

// val f = { a: Int -> { b: Double -> a * (1 + b / 100) } }
// x: Int, y: Double -> partialA(x, f)(y) == f(x)(y)
fun <T, V> partialA(x: T, f: (T) -> (V) -> V): (V) -> V = { y ->
    f(x)(y)
}

// y.isNaN() || y.isInfinite() || partialB(y, f)(x) == f(x)(y)
fun <T, V> partialB(y: V, f: (T) -> (V) -> V): (T) -> V = { x ->
    f(x)(y)
}

// curried<Int, Double, String, Boolean>()(a)(b)(c)(d) == "$a, $b, $c, $d"
fun <T, U, V, W> curried(): (T) -> ((U) -> ((V) -> ((W) -> String))) = { a: T ->
    { b: U ->
        { c: V ->
            { d: W ->
                "$a, $b, $c, $d"
            }
        }
    }
}

// x: Int, y: Double -> curry(f)(x)(y) == f(x, y)
fun <T, U, V> curry(f: (T, U) -> V): (T) -> ((U) -> V) = { x: T ->
    { y: U ->
        f(x, y)
    }
}

// x: Int, y: Double -> swapArgs(curry(f))(y)(x) == f(x, y)
// fun swapArgs(crr: (Int) -> (Double) -> Double): (Double) -> (Int) -> (Double)
fun <T, U, V>swapArgs(crr: (T) -> (U) -> V): (U) -> (T) -> (V) = { y ->
    { x -> crr(x)(y) }
}
