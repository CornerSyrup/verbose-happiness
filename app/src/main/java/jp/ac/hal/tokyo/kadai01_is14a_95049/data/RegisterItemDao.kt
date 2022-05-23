package jp.ac.hal.tokyo.kadai01_is14a_95049.data

import androidx.room.*

@Dao
interface RegisterItemDao {
    @Insert
    fun insert(item: RegisterItem)

    @Query("SELECT * FROM RegisteredItems")
    fun getAllItems(): List<RegisterItem>

    @Query("SELECT * FROM RegisteredItems WHERE id in (:id)")
    fun getItemByIds(id: IntArray): List<RegisterItem>

    @Query("SELECT * FROM RegisteredItems WHERE id = (:id)")
    fun getItemById(id: Int): RegisterItem

    @Update
    fun update(item: RegisterItem)

    @Delete
    fun delete(item: RegisterItem)

    @Query("DELETE FROM RegisteredItems")
    fun deleteAll()
}

