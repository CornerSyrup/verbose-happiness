package jp.ac.hal.tokyo.kadai01_is14a_95049

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import jp.ac.hal.tokyo.kadai01_is14a_95049.data.RegisterItem
import jp.ac.hal.tokyo.kadai01_is14a_95049.databinding.FragmentRegisterPageBinding

class RegisterPage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding: FragmentRegisterPageBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_register_page, container, false)
        return dataBinding.root.apply {
            dataBinding.ddlCategory.adapter = ArrayAdapter(
                context,
                com.microsoft.fluentui.R.layout.support_simple_spinner_dropdown_item,
                ItemCategory.values().map { context.getString(it.res) })
        }.apply {
            dataBinding.vm = RegisterPageViewModel(RegisterItem())
        }
    }
}

