package jp.ac.hal.tokyo.kadai01_is14a_95049.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import jp.ac.hal.tokyo.kadai01_is14a_95049.R
import jp.ac.hal.tokyo.kadai01_is14a_95049.data.RegisterItem
import jp.ac.hal.tokyo.kadai01_is14a_95049.data.RegisteredItemDb
import jp.ac.hal.tokyo.kadai01_is14a_95049.databinding.FragmentRegisterItemDetailViewBinding

class RegisterItemsAdapter(private val itemList: MutableList<RegisterItem>) :
    RecyclerView.Adapter<RegisterItemsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val dataBinding: FragmentRegisterItemDetailViewBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.fragment_register_item_detail_view,
                parent, false
            )
        return ViewHolder(dataBinding.root, dataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.position = position + 1 // 0-base to 1-base
        holder.binding.total = itemCount
        holder.binding.model = itemList[position]
        holder.binding.deleteCommand = View.OnClickListener {
            RegisteredItemDb.getRegisterItemDb()!!.registerItemDao() // remove from repo
                .delete(holder.binding.model as RegisterItem)
            itemList.removeAt(position) // remote from cache
            notifyItemRemoved(position) // refresh
        }
    }

    override fun getItemCount() = itemList.size

    data class ViewHolder(val itemView: View, var binding: FragmentRegisterItemDetailViewBinding) :
        RecyclerView.ViewHolder(itemView)
}
