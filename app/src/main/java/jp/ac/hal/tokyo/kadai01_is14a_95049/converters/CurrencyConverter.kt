package jp.ac.hal.tokyo.kadai01_is14a_95049.converters

import androidx.databinding.InverseMethod

object CurrencyConverter {
    @JvmStatic
    @InverseMethod("toCurrency")
    fun toString(value: Float): String {
        return value.toString()
    }

    @JvmStatic
    fun toCurrency(value: String): Float {
        return value.toFloat()
    }
}
