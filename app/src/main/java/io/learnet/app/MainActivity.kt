package io.learnet.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import io.learnet.app.databinding.ActivityMainBinding
import io.learnet.app.ui.event.EventHomeFragment
import io.learnet.app.ui.home.HomeFragment
import io.learnet.app.ui.match.IntroGoalsFragment
import io.learnet.app.ui.profile.UserProfileFragment
import io.learnet.app.ui.task.TaskHomeFragment
import io.learnet.app.ui.utils.SoftInputAssist


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var chipNavigationBar: ChipNavigationBar
    private lateinit var softAssist: SoftInputAssist

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chipNavigationBar = findViewById(R.id.bottom_nav)
        chipNavigationBar.setItemSelected(R.id.bottom_nav, true)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                TaskHomeFragment()
//                HomeFragment()
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
        bottomMenu()
        softAssist = SoftInputAssist(this, chipNavigationBar.layoutParams.height)

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


    private fun bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener { id ->
                var fragment: Fragment? = null
                when (id) {
                    R.id.home -> fragment = HomeFragment()
                    R.id.task -> fragment = IntroGoalsFragment()
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
}