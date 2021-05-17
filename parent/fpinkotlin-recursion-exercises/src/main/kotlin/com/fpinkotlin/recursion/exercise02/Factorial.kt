package com.fpinkotlin.recursion.exercise02

import java.math.BigInteger

object Factorial {
    val factorial: (Int)-> BigInteger by lazy { { n: Int ->
        if (n <= 1) n.toBigInteger() else n.toBigInteger() * factorial(n - 1)
    } }

    private lateinit var fact: (Int)-> BigInteger
    init {
        fact = { n -> if (n <= 1) n.toBigInteger() else n.toBigInteger() * fact(n - 1) }
    }
    val factorial2 = fact

    val factorial3: (Int)-> BigInteger = { n: Int ->
        tailrec fun fact(x: Int, acc: BigInteger): BigInteger {
            if (x <= 0) return acc
            return fact(x - 1, x.toBigInteger() * acc)
        }
        fact(n, BigInteger.ZERO);
    }
}