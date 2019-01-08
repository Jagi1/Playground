package seba.playground

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import seba.playground.Fragments.MyDialogFragment
import android.support.design.widget.NavigationView



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    // Listener dla elementow bocznego lewego menu
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        mDrawer.closeDrawers()
        when (p0.itemId) {
            R.id.nav_quit -> showMyDialog()
            R.id.nav_view_pager -> startActivity(Intent(this,ViewPagerActivity::class.java))
            R.id.nav_navigation_bar -> startActivity(Intent(this,NavigationBarActivity::class.java))
        }
        return false
    }

    private lateinit var toolbar: Toolbar
    private lateinit var mDrawer: DrawerLayout
    private lateinit var drawerToggle: ActionBarDrawerToggle
    private lateinit var nvDrawer: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        mDrawer = findViewById(R.id.drawer_layout)
        nvDrawer = findViewById(R.id.nvView)
        drawerToggle = setupDrawerToggle()
        setSupportActionBar(toolbar)
        nvDrawer.setNavigationItemSelectedListener(this)
    }

    private fun showMyDialog() {
        val fm = supportFragmentManager
        val myDialogFragment: MyDialogFragment = MyDialogFragment.newInstance("Are you sure you want to quit?")
        myDialogFragment.show(fm,"myDialogFragment")
    }

    private fun setupDrawerToggle(): ActionBarDrawerToggle {
        return ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close)
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }
}
