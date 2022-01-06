package com.sampson.kotlinintegrationtests

import java.math.BigInteger
import kotlin.jvm.Throws

class FactorialGenerator {
    @Throws(FactorialNotFoundException::class)
    fun factorial(n: Int): BigInteger {
        if (n < 0) {
            throw FactorialNotFoundException
        }
        var result = BigInteger.ONE
        for (i in 1..n) {
            result = result.times(i.toBigInteger())
        }
        return result
    }

    object FactorialNotFoundException : Throwable()
}