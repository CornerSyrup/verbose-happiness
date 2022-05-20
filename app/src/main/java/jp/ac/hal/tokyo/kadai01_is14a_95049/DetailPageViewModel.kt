package jp.ac.hal.tokyo.kadai01_is14a_95049

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