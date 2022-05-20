package jp.ac.hal.tokyo.kadai01_is14a_95049

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jakewharton.threetenabp.AndroidThreeTen
import jp.ac.hal.tokyo.kadai01_is14a_95049.data.RegisteredItemDb

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<BottomNavigationView>(R.id.main_nav_view).setupWithNavController(
            (supportFragmentManager.findFragmentById(R.id.main_nav_container) as NavHostFragment).navController
        )
        RegisteredItemDb.setUpRegisterItemDb(this)
        AndroidThreeTen.init(this)
    }
}