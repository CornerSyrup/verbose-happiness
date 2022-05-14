package jp.ac.hal.tokyo.kadai01_is14a_95049.converters

import androidx.databinding.InverseMethod
import jp.ac.hal.tokyo.kadai01_is14a_95049.ItemCategory

object ItemCategoryConverter {
    @JvmStatic
    @InverseMethod("toItemCategory")
    fun toInteger(value: ItemCategory?): Int {
        return (value ?: ItemCategory.Others).ordinal
    }

    @JvmStatic
    fun toItemCategory(value: Int): ItemCategory {
        return ItemCategory.values()[value]
    }
}
