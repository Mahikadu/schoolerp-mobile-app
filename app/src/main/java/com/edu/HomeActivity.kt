package com.edu

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.edu.DataModel.Student
import com.edu.Fragment.About
import com.edu.Fragment.Attendance
import com.edu.Fragment.ContactUs
import com.edu.Fragment.DivStd
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, Attendance.OnFragmentInteractionListener, DivStd.OnListFragmentInteractionListener, About.OnAboutFragmentInteractionListener, ContactUs.OnFragmentInteractionListener {

///    private lateinit var calendar: Calendar

    fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.beginTransaction().add(frameId, fragment).commit()
    }

    fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.beginTransaction().replace(frameId, fragment).addToBackStack(fragment.toString()).commit();
    }

    override fun onListFragmentInteraction() {
        replaceFragment(Attendance(), R.id.container)
    }

    override fun onFragmentInteraction(uri: Uri) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        addFragment(DivStd(), R.id.container)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun studentClicked(student: Student) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(this, "clicked: ${student.firstName}", Toast.LENGTH_SHORT).show();
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.home, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        Log.d("TAG", item.itemId.toString())
//        when (item.itemId) {
//            R.id.action_settings -> return true;
//            else ->
//            return super.onOptionsItemSelected(item)
//        }
//    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_attendance -> {
                replaceFragment(DivStd(), R.id.container)
            }
//            R.id.nav_gallery -> {
//
//            }
//            R.id.nav_slideshow -> {
//
//            }
//            R.id.nav_manage -> {
//
//            }
            R.id.nav_about -> {
                replaceFragment(About(), R.id.container)
            }
            R.id.nav_contactUs -> {
                replaceFragment(ContactUs(), R.id.container)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
