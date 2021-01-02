package com.example.navigationcomponentworking3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Getting the nav controller
        var navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment  //typecasting
        navController = navHostFragment.findNavController()

//        Initializing the appBarConfiguration. Responsible for the hamburger icon and making top level fragments.
//        The fragments in the setof function are the top level fragments of the app.
//        Putting the drawer_layout as the second parameter results in the creation of the hamburger icon.
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragmentA, R.id.searchFragment),
            drawer_layout
        )


//        Making the toolbar the default action bar
        setSupportActionBar(toolbar)

//        Linking the nav controller with the action bar.
        setupActionBarWithNavController(navController, appBarConfiguration)

//        Linking the nav controller with the bottom nav view
        bottom_nav_view.setupWithNavController(navController)

        //    Linking the nav controller with navigation drawer.
        nav_drawer.setupWithNavController(navController)

    }


    //    Overriding the Up functionality
    override fun onSupportNavigateUp(): Boolean {
//        if we do not supply the appBarConfiguration in the navigateUp function, the hamburger icon won't do anything.
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.aboutFragment) {
            navController.navigate(NavGraphDirections.actionGlobalAboutUsFragment())
            true
        } else {
            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }

    }
}