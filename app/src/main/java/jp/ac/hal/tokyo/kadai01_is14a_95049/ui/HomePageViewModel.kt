package jp.ac.hal.tokyo.kadai01_is14a_95049.ui

import android.view.View
import androidx.navigation.findNavController

class HomePageViewModel {
    fun navigateToRegisterPage(view: View) {
        view.findNavController().navigate(HomePageDirections.actionHomeToRegister())
    }

    fun navigateToDetailPage(view: View) {
        view.findNavController().navigate(HomePageDirections.actionHomeToDetail())
    }
}