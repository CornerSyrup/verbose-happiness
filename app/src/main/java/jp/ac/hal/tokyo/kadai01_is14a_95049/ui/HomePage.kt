package jp.ac.hal.tokyo.kadai01_is14a_95049.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import jp.ac.hal.tokyo.kadai01_is14a_95049.R
import jp.ac.hal.tokyo.kadai01_is14a_95049.databinding.FragmentHomePageBinding

class HomePage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding: FragmentHomePageBinding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_home_page, container, false
            )
        return dataBinding.root.apply {
            dataBinding.vm = HomePageViewModel()
        }
    }
}

