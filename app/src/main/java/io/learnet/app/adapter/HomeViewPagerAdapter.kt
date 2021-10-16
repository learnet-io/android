package io.learnet.app.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.learnet.app.ui.posts.PostDetailFragment
import io.learnet.app.ui.posts.PostsHomePublicFragment

/**
* @author Bizuwork Melesse
* created on 10/9/21
*/
class HomeViewPagerAdapter(fragmentManager: FragmentManager,
                           lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       return when (position) {
             0 -> PostsHomePublicFragment()
            else -> PostsHomePublicFragment()
        }
    }
}