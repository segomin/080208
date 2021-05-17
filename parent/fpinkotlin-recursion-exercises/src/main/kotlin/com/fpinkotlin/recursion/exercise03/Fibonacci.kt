package com.fpinkotlin.recursion.exercise03

import java.math.BigInteger


fun fib(x: Int): BigInteger {
    tailrec fun fibTailed(acc1: BigInteger, acc2: BigInteger, x: Int): BigInteger {
        return when (x) {
            0 -> BigInteger.ONE
            1 -> acc1 + acc2
            else -> fibTailed(acc2, acc1 + acc2, x - 1)
        }
    }

    return fibTailed(BigInteger.ZERO, BigInteger.ONE, x)
}

// f(n) == 2 ** n
//fun fib(number: Int): Int =
//    if (number == 0 || number == 1)
//        1
//    else
//        fib(number - 1) + fib(number - 2)
