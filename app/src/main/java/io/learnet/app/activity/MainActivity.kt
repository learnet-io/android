package io.learnet.app.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import io.learnet.app.R
import io.learnet.app.data.dto.User
import io.learnet.app.data.repo.AuthRepo
import io.learnet.app.databinding.ActivityMainBinding
import io.learnet.app.ui.event.EventHomeFragment
import io.learnet.app.ui.home.HomeFragment
import io.learnet.app.ui.profile.UserProfileFragment
import io.learnet.app.ui.task.TaskHomeFragment
import io.learnet.app.ui.utils.SoftInputAssist


class MainActivity : AppCompatActivity(), FirebaseAuth.AuthStateListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var chipNavigationBar: ChipNavigationBar
    private lateinit var softAssist: SoftInputAssist
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFirebase()
        initNavigation()
        val user: User = getUserFromIntent()
        

        

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
//                TaskHomeFragment()
                HomeFragment()
//                IntroGoalsFragment()
//                LoginFragment()
//                MatchDetailFragment(),
//                MatchIntroFragment()
//                EventHomeFragment()
//                EventDetailEditFragment()
//                EventDetailFragment()
//                EventListFragment()
//                UserProfileEditFragment()
//                UserProfileFragment()
//                CreatePostReplyFragment()
//                CreatePostFragment()
//                PostsHomeFragment()
//            TextInputFragment()
            ).commit()
        

    }

    private fun getUserFromIntent(): User {
        return (intent.getSerializableExtra(AuthRepo.USER) as User?)!!
    }

    private fun initNavigation() {
        chipNavigationBar = findViewById(R.id.bottom_nav)
        chipNavigationBar.setItemSelected(R.id.bottom_nav, true)
        bottomMenu()
        softAssist = SoftInputAssist(this, chipNavigationBar.layoutParams.height)
    }

    private fun initFirebase() {
        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun onResume() {
        softAssist.onResume()
        super.onResume()
    }

    override fun onPause() {
        softAssist.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        softAssist.onDestroy()
        super.onDestroy()
    }

    override fun onStart() {
        super.onStart()
        goToLoginScreen()
    }

    private fun bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener { id ->
                var fragment: Fragment? = null
                when (id) {
                    R.id.home -> fragment = HomeFragment()
                    R.id.task -> fragment = TaskHomeFragment()
                    R.id.events -> fragment = EventHomeFragment()
                    R.id.profile -> fragment = UserProfileFragment()
                }
                if (fragment != null) {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.fragment_container,
                            fragment
                        ).commit()
                }
        }
    }

    override fun onAuthStateChanged(p0: FirebaseAuth) {
        // If a user session has expired or user not found, re-direct them to login screen
        goToLoginScreen()
    }

    private fun goToLoginScreen() {
        if (firebaseAuth.currentUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}