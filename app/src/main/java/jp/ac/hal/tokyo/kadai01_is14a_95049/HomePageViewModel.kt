package jp.ac.hal.tokyo.kadai01_is14a_95049

import android.view.View
import androidx.navigation.findNavController

class HomePageViewModel {
    fun navigateToRegisterPage(view: View) {
        view.findNavController().navigate(R.id.action_home_to_register)
    }

    fun navigateToDetailPage(view: View) {
//        view.findNavController().navigate(R.id.action_home_to_detail)
    }
}