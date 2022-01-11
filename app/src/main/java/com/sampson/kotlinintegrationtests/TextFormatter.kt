package com.sampson.kotlinintegrationtests

import android.annotation.SuppressLint
import android.content.Context

class TextFormatter(
    private val factorialGenerator: FactorialGenerator,
    private val context: Context
) {
    @SuppressLint("StringFormatInvalid")
    fun getFactorialResult(n: Int): String {
        return try {
            context.getString(R.string.result,factorialGenerator.factorial(n).toString())
        } catch (e: FactorialGenerator.FactorialNotFoundException) {
            context.getString(R.string.error)
        }
    }
}