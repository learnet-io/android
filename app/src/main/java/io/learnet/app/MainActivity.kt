package io.learnet.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import io.learnet.app.databinding.ActivityMainBinding
import io.learnet.app.ui.posts.PostDetailFragment
import io.learnet.app.ui.posts.PostsHomeFragment
import io.learnet.app.ui.profile.UserProfileFragment
import io.learnet.app.ui.textinput.RichTextFragment
import io.learnet.app.ui.textinput.TextInputFragment
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
                UserProfileFragment()
//                RichTextFragment()
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
                    R.id.home -> fragment = PostsHomeFragment()
                    R.id.task -> fragment = IntroGoalsFragment()
                    R.id.group -> fragment = RichTextFragment()
                    R.id.profile -> fragment = PostDetailFragment()
                    R.id.events -> fragment = TextInputFragment()
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