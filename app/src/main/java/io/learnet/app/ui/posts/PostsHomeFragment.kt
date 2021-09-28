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


class PostsHomeFragment : Fragment() {

    lateinit var posts: ArrayList<PostItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Recent Posts"
        val rvPosts = view?.findViewById(R.id.rvPostInfiniteScroll) as RecyclerView
        posts = DemoPostCreator.createPostList(20)
        val adapter = PostAdapter(posts)
        rvPosts.adapter = adapter
        rvPosts.layoutManager = LinearLayoutManager(activity)
    }
}