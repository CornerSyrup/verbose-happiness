package jp.ac.hal.tokyo.kadai01_is14a_95049

import android.util.Log
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import jp.ac.hal.tokyo.kadai01_is14a_95049.data.RegisterItem
import jp.ac.hal.tokyo.kadai01_is14a_95049.data.RegisteredItemDb

class DetailPageViewModel : BaseObservable() {
    @Bindable
    private lateinit var items: List<RegisterItem>

    init {
        refresh()
    }

    fun debugClick(view: View) {
        Log.i("DB", "debugClick: $items")
    }

    val adapter: RegisterItemsAdapter
        get() = RegisterItemsAdapter(items)

    fun refresh() {
        items = RegisteredItemDb.getRegisterItemDb()!!.registerItemDao().getAllItems()
        notifyPropertyChanged(BR.items)
    }

    fun clear() {
        RegisteredItemDb.getRegisterItemDb()!!.registerItemDao().deleteAll()
        notifyPropertyChanged(BR.items)
    }
}