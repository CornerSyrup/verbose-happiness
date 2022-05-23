package jp.ac.hal.tokyo.kadai01_is14a_95049.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RegisterItem::class], version = 1)
abstract class RegisteredItemDb : RoomDatabase() {
    abstract fun registerItemDao(): RegisterItemDao

    companion object {
        @Volatile
        private var instance: RegisteredItemDb? = null

        fun setUpRegisterItemDb(context: Context) {
            instance = Room.databaseBuilder(
                context.applicationContext,
                RegisteredItemDb::class.java,
                "registered-item-db"
            ).allowMainThreadQueries().build()
        }

        /**
         * Gets RegisteredItem Database.
         * Please call setUpRegisterItemDb once before calling getRegisterItemDb.
         * Otherwise, this method will always return null.
         */
        fun getRegisterItemDb(): RegisteredItemDb? {
            return instance
        }
    }
}