package jp.ac.hal.tokyo.kadai01_is14a_95049

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import jp.ac.hal.tokyo.kadai01_is14a_95049.data.RegisterItem
import jp.ac.hal.tokyo.kadai01_is14a_95049.databinding.FragmentRegisterItemDetailViewBinding

class RegisterItemsAdapter(private val itemList: List<RegisterItem>) :
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
        holder.binding.position = position
        holder.binding.total = itemCount
        holder.binding.model = itemList[position]
    }

    override fun getItemCount() = itemList.size

    data class ViewHolder(val itemView: View, var binding: FragmentRegisterItemDetailViewBinding) :
        RecyclerView.ViewHolder(itemView)
}
