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
import io.learnet.app.ui.utils.SectionHeader
import io.learnet.app.ui.utils.BaseViewHolder

/**
 * @author Bizuwork Melesse
 * created on 9/26/21
 */
class PostAdapter(private val viewItems: List<*>) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        private const val TYPE_POST_HEADER = 0
        private const val TYPE_POST_ITEM = 1
    }

    inner class PostItemViewHolder(itemView: View) : BaseViewHolder<PostItem>(itemView) {
        override fun bind(item: PostItem) {
            val avatarView = itemView.findViewById<ImageView>(R.id.ivDetailPosterAvatar)
            val postTitleView = itemView.findViewById<TextView>(R.id.tvPostTitle)
            val postBookmarkView = itemView.findViewById<TextView>(R.id.tvPostDetailBookmark)
            val authorView = itemView.findViewById<TextView>(R.id.tvPostAuthor)
            val authorTimeStampDividerView = itemView.findViewById<TextView>(R.id.tvPostAuthorTimestampDivider)
            val timestampView = itemView.findViewById<TextView>(R.id.tvPostTimestamp)
            val summaryView = itemView.findViewById<TextView>(R.id.tvPostSummary)
            val voteCountView = itemView.findViewById<TextView>(R.id.tvPostVoteCount)
            val replyCountView = itemView.findViewById<TextView>(R.id.tvPostReplyCount)
            val viewCountView = itemView.findViewById<TextView>(R.id.tvPostViewCount)

            Picasso.get().load(item.avatarUrl).into(avatarView)
            postTitleView.text = item.title
            authorView.text = "${item.authorFirstName} ${item.authorLastName}"
            timestampView.text = item.timestamp
            summaryView.text = item.summary
            voteCountView.text = "${item.voteCount} votes"
            replyCountView.text = "${item.replyCount} replies"
            viewCountView.text = "${item.viewCount} views"
        }
    }

    inner class PostSectionHeaderViewHolder(itemView: View) : BaseViewHolder<SectionHeader>(itemView) {
        override fun bind(item: SectionHeader) {
            val headerView = itemView.findViewById<TextView>(R.id.tvPostSectionHeader)
            headerView.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_POST_ITEM -> {
                val postItemView = inflater.inflate(R.layout.post_item, parent, false)
                PostItemViewHolder(postItemView)
            }
            TYPE_POST_HEADER -> {
                val postHeaderView = inflater.inflate(R.layout.posts_section_header, parent, false)
                PostSectionHeaderViewHolder(postHeaderView)
            } else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is PostItemViewHolder -> holder.bind(viewItems[position] as PostItem)
            is PostSectionHeaderViewHolder -> holder.bind(viewItems[position] as SectionHeader)
        }
    }

    override fun getItemCount(): Int {
        return viewItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (viewItems[position]) {
            is SectionHeader -> TYPE_POST_HEADER
            is PostItem -> TYPE_POST_ITEM
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }
}