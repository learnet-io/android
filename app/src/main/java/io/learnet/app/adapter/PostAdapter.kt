package io.learnet.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.learnet.app.R
import io.learnet.app.ui.posts.PostItem

/**
 * @author Bizuwork Melesse
 * created on 9/26/21
 */
class PostAdapter(private val posts: List<PostItem>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarView = itemView.findViewById<ImageView>(R.id.ivPosterAvatar)
        val postTitleView = itemView.findViewById<TextView>(R.id.tvPostTitle)
        val postBookmarkView = itemView.findViewById<TextView>(R.id.tvPostBookmark)
        val authorView = itemView.findViewById<TextView>(R.id.tvPostAuthor)
        val authorTimeStampDividerView = itemView.findViewById<TextView>(R.id.tvPostAuthorTimestampDivider)
        val timestampView = itemView.findViewById<TextView>(R.id.tvPostTimestamp)
        val summaryView = itemView.findViewById<TextView>(R.id.tvPostSummary)
        val voteCountView = itemView.findViewById<TextView>(R.id.tvPostVoteCount)
        val replyCountView = itemView.findViewById<TextView>(R.id.tvPostReplyCount)
        val viewCountView = itemView.findViewById<TextView>(R.id.tvPostViewCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.post_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post: PostItem = posts[position]
        Picasso.get().load(post.avatarUrl).into(holder.avatarView)
        holder.postTitleView.text = post.title
        holder.authorView.text = "${post.authorFirstName} ${post.authorLastName}"
        holder.timestampView.text = post.timestamp
        holder.summaryView.text = post.summary
        holder.voteCountView.text = "${post.voteCount} votes"
        holder.replyCountView.text = "${post.replyCount} replies"
        holder.viewCountView.text = "${post.viewCount} views"
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}