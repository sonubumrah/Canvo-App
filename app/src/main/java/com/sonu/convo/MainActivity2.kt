package com.sonu.convo


import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    lateinit var appBarLayout: AppBarLayout
    lateinit var toolbar:androidx.appcompat.widget.Toolbar
    var previousMenuItem:MenuItem?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        drawerLayout=findViewById(R.id.DrawerLayout)
        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        frameLayout=findViewById(R.id.FrameLayout)
        navigationView=findViewById(R.id.NavigationDrawer)
        appBarLayout=findViewById(R.id.appBarLayout)
        toolbar=findViewById(R.id.toolBar)
        setUpToolBar()
        openDashBoard()
        val actionBarDrawerToggle=ActionBarDrawerToggle(this@MainActivity2,drawerLayout,R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener {
            if(previousMenuItem!=null){
                previousMenuItem?.isChecked=false
            }
            it.isChecked=true
            it.isCheckable=true
            previousMenuItem=it
            when(it.itemId) {
                R.id.dashboard-> {
                    openDashBoard()
                }
                R.id.CK -> {
                    supportFragmentManager.beginTransaction().replace(R.id.FrameLayout, CK())
                        .commit()
                    drawerLayout.closeDrawers()
                    supportActionBar?.title = "C-->K"
                }
                R.id.KC -> {
                    supportFragmentManager.beginTransaction().replace(R.id.FrameLayout, KC())
                        .commit()
                    drawerLayout.closeDrawers()
                    supportActionBar?.title = "K-->C"

                }
                R.id.CF -> {
                    supportFragmentManager.beginTransaction().replace(R.id.FrameLayout, CF())
                        .commit()
                    drawerLayout.closeDrawers()
                    supportActionBar?.title = "C-->F"

                }
                R.id.FC -> {
                    supportFragmentManager.beginTransaction().replace(R.id.FrameLayout, FC())
                    drawerLayout.closeDrawers()
                    supportActionBar?.title = "F-->C"

                }
                R.id.FK -> {
                    supportFragmentManager.beginTransaction().replace(R.id.FrameLayout, FK())
                        .commit()
                    drawerLayout.closeDrawers()
                    supportActionBar?.title = "F-->K"

                }
                R.id.KF -> {
                    supportFragmentManager.beginTransaction().replace(R.id.FrameLayout, KF())
                        .commit()
                    drawerLayout.closeDrawers()
                    supportActionBar?.title = "K-->F"

                }

            }
            return@setNavigationItemSelectedListener true

        }
    }
    private fun setUpToolBar(){

        setSupportActionBar(toolbar)
        supportActionBar?.title="Tool Bar"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

    }
    fun openDashBoard(){
        supportFragmentManager.beginTransaction().replace(R.id.FrameLayout,Dashboard()).commit()
        drawerLayout.closeDrawers()
        navigationView.setCheckedItem(R.id.dashboard)
        supportActionBar?.title="Home"

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.FrameLayout)
        when(frag){
            !is Dashboard->openDashBoard()
            else->super.onBackPressed()
        }

    }
}