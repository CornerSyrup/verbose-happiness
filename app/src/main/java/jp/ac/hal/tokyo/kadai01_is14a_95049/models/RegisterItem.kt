package jp.ac.hal.tokyo.kadai01_is14a_95049.models

import jp.ac.hal.tokyo.kadai01_is14a_95049.ItemCategory

data class RegisterItem(
    var year: Int = 0,
    var month: Int = 0,
    var day: Int = 0,
    var title: String = "",
    var category: ItemCategory = ItemCategory.Others,
    /**
     * True for income record, false for expense record.
     */
    var flow: Boolean = false,
    var amount: Float = 0f,
)