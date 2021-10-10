package io.learnet.app.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.learnet.app.ui.posts.PostDetailFragment
import io.learnet.app.ui.posts.PostsHomeFragment

/**
* @author Bizuwork Melesse
* created on 10/9/21
*/
class HomeViewPagerAdapter(fragmentManager: FragmentManager,
                           lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {
//    private val fragments = ArrayList<Fragment>()

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       return when (position) {
             0 -> PostsHomeFragment()
            else -> PostDetailFragment()

        }
    }
}