package jp.ac.hal.tokyo.kadai01_is14a_95049.ui

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import jp.ac.hal.tokyo.kadai01_is14a_95049.BR
import jp.ac.hal.tokyo.kadai01_is14a_95049.data.RegisterItem
import jp.ac.hal.tokyo.kadai01_is14a_95049.data.RegisteredItemDb
import jp.ac.hal.tokyo.kadai01_is14a_95049.ui.adapter.RegisterItemsAdapter

class DetailPageViewModel : BaseObservable() {
    @Bindable
    private lateinit var items: List<RegisterItem>

    init {
        refresh()
    }

    val adapter: RegisterItemsAdapter
        get() = RegisterItemsAdapter(items as MutableList)

    fun refresh() {
        items = RegisteredItemDb.getRegisterItemDb()!!.registerItemDao().getAllItems()
        notifyPropertyChanged(BR.items)
    }

    fun clear() {
        RegisteredItemDb.getRegisterItemDb()!!.registerItemDao().deleteAll()
        notifyPropertyChanged(BR.items)
    }
}