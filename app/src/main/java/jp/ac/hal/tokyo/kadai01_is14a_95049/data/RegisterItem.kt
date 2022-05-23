package jp.ac.hal.tokyo.kadai01_is14a_95049.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RegisteredItems")
data class RegisterItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
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

