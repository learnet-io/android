package io.learnet.app.ui.posts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.learnet.app.R
import io.learnet.app.adapter.PostDetailAdapter
import io.learnet.app.ui.utils.SectionHeader


class PostDetailFragment : Fragment(), View.OnClickListener {

    private var postItems: ArrayList<Any> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFabListener()

        val rvPostDetail = view?.findViewById(R.id.rv_post_detail) as RecyclerView

        // Add a section header
        val sectionHeader = SectionHeader(getString(R.string.post_detail_section_header))
        postItems.add(sectionHeader)

        // Add post items
        postItems.add(DemoPostCreator.createPostDetail())

        // Add replies
        val repliesHeader = SectionHeader("Replies (80)")
        postItems.add(repliesHeader)
        postItems.addAll(DemoPostCreator.createPostReplies(5))
        val adapter = PostDetailAdapter(postItems)
        rvPostDetail.adapter = adapter
        rvPostDetail.layoutManager = LinearLayoutManager(activity)
    }

    private fun initFabListener() {
        val fab = view?.findViewById<FloatingActionButton>(R.id.i_fab_post_reply)
        fab?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.i_fab_post_reply -> launchPostReplyInputFragment()
        }
    }

    private fun launchPostReplyInputFragment() {
        activity?.supportFragmentManager!!.beginTransaction()
            .replace(R.id.fragment_container, CreatePostReplyFragment())
            .addToBackStack(null)
            .commit()
    }
}