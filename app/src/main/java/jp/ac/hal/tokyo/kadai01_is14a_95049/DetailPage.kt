package jp.ac.hal.tokyo.kadai01_is14a_95049

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import jp.ac.hal.tokyo.kadai01_is14a_95049.databinding.FragmentDetailPageBinding

class DetailPage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinging: FragmentDetailPageBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_page, container, false)
        return dataBinging.root.apply {
            dataBinging.vm = DetailPageViewModel()
        }
    }
}
