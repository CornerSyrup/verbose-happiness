package jp.ac.hal.tokyo.kadai01_is14a_95049.ui

import android.view.View
import androidx.navigation.findNavController
import jp.ac.hal.tokyo.kadai01_is14a_95049.R

class HomePageViewModel {
    fun navigateToRegisterPage(view: View) {
        view.findNavController().navigate(R.id.action_home_to_register)
    }

    fun navigateToDetailPage(view: View) {
        view.findNavController().navigate(R.id.action_home_to_detail)
    }
}