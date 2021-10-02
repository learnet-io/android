package io.learnet.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import io.learnet.app.databinding.ActivityMainBinding
import io.learnet.app.ui.posts.PostDetailFragment
import io.learnet.app.ui.posts.PostsHomeFragment
import io.learnet.app.ui.richtext.RichTextFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var chipNavigationBar: ChipNavigationBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chipNavigationBar = findViewById(R.id.bottom_nav)
        chipNavigationBar.setItemSelected(R.id.bottom_nav, true)
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                RichTextFragment()
//                PostsHomeFragment()
            ).commit()
        bottomMenu()
    }

    private fun bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener { id ->
                var fragment: Fragment? = null
                when (id) {
                    R.id.home -> fragment = PostsHomeFragment()
                    R.id.task -> fragment = IntroGoalsFragment()
                    R.id.group -> fragment = RichTextFragment()
                    R.id.profile -> fragment = PostDetailFragment()
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