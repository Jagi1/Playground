package seba.playground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.ActionBar

class NavigationBarActivity : AppCompatActivity() {

//    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_bar)

        // Inicjalizacja NavigationBar
//        toolbar = supportActionBar
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
    }
}
