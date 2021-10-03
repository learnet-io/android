package io.learnet.app.ui.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.learnet.app.R
import io.learnet.app.adapter.PostAdapter
import io.learnet.app.ui.utils.SectionHeader


class PostsHomeFragment : Fragment() {

    var postItems: ArrayList<Any> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvPosts = view?.findViewById(R.id.rvPostInfiniteScroll) as RecyclerView

        // Add a section header
        val sectionHeader = SectionHeader(getString(R.string.post_section_recent_header))
        postItems.add(sectionHeader)

        // Add post items
        postItems.addAll(DemoPostCreator.createPostList(20))
        val adapter = PostAdapter(postItems)
        rvPosts.adapter = adapter
        rvPosts.layoutManager = LinearLayoutManager(activity)
    }
}