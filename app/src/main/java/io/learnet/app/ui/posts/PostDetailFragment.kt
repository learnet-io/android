package io.learnet.app.ui.posts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.learnet.app.R
import io.learnet.app.adapter.PostAdapter
import io.learnet.app.adapter.PostDetailAdapter


class PostDetailFragment : Fragment() {

    var postItems: ArrayList<Any> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvPostDetail = view?.findViewById(R.id.rvPostDetailInfiniteScroll) as RecyclerView

        // Add a section header
        val sectionHeader = PostSectionHeader(getString(R.string.post_detail_section_header))
        postItems.add(sectionHeader)

        // Add post items
        postItems.add(DemoPostCreator.createPostDetail())
        val adapter = PostDetailAdapter(postItems)
        rvPostDetail.adapter = adapter
        rvPostDetail.layoutManager = LinearLayoutManager(activity)
    }
}