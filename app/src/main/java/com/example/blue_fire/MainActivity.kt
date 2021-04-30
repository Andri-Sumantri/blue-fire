package com.example.blue_fire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    // Initialise the DrawerLayout, NavigationView and ToggleBar
    private lateinit var drawerLayout    : DrawerLayout
    private lateinit var actionBarToggle : ActionBarDrawerToggle
    private lateinit var navDrawerView   : NavigationView

    // Initialise the NavigationBattomBar
    private lateinit var bottomNavigation : BottomNavigationView

    private fun setCurrentFragment(fragment:Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentCointainer,fragment)
            commit()
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call fragment from bottom navigation view
        val firstFragment   = Home()
        val secondFragment  = Song()
        val thirdFragment   = Album()
        val fourthFragment  = Artist()

        setCurrentFragment(firstFragment)

        bottomNavigation = findViewById(R.id.navBottom)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home    -> setCurrentFragment(firstFragment)
                R.id.navigation_song    -> setCurrentFragment(secondFragment)
                R.id.navigation_albums  -> setCurrentFragment(thirdFragment)
                R.id.navigation_artists -> setCurrentFragment(fourthFragment)
            }
            true
        }

        // Call findViewById on the DrawerLayout
        drawerLayout = findViewById(R.id.activity_main)

        // Pass the ActionBarToggle action into the drawerListener
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)

        // Display the hamburger icon to Launch the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Call syncState() on the action bar so it'll automatically
        // change to the back button when the drawer layout is open
        actionBarToggle.syncState()

        // Call findViewById on the NavigationView
        navDrawerView = findViewById(R.id.navDrawer)

        // Call setNavigationItemSelectedListener on the NavigationView
        // to detect when items are clicked
        navDrawerView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myProfile -> {
                    Toast.makeText(this, "Go to My Profile", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.myEmployeee -> {
                    Toast.makeText(this, "Go to Our Employee", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.register -> {
                    val intent = Intent(applicationContext, Register::class.java)
                    startActivity(intent)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    // override the onSupportNavigatteUp() function to open and close the Drawer
    override fun onSupportNavigateUp(): Boolean {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START) // close drawer
        } else {
            this.drawerLayout.openDrawer(GravityCompat.START) // open drawer
        }
        return true
    }

    // Call inflate toobar Menu to Main Activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == R.id.favourite) {
            Toast.makeText(this, "Thanks You make me your favourite", Toast.LENGTH_SHORT).show()
            return true
        }
        else if(id == R.id.search){
            Toast.makeText(this,"Search Cklicked", Toast.LENGTH_SHORT).show()
            return true
        }
        else if(id == R.id.setting) {
            Toast.makeText(this, "Go to setting", Toast.LENGTH_SHORT).show()
            return true
        }
        else if(id == R.id.logout) {
            Toast.makeText(this, "Logout and go to login form", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}