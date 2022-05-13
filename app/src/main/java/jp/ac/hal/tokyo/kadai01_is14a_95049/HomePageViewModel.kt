package jp.ac.hal.tokyo.kadai01_is14a_95049

import android.view.View
import androidx.navigation.NavController

class HomePageViewModel(private val nav: NavController) {
    fun navigateToRegisterPage(view: View) {
        nav.navigate(R.id.action_home_to_register)
    }

    fun navigateToDetailPage(view: View) {
        nav.navigate(R.id.action_home_to_detail)
    }
}