package io.learnet.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.learnet.app.R
import io.learnet.app.ui.posts.PostDetailItem
import io.learnet.app.ui.posts.PostReplyItem
import io.learnet.app.ui.posts.PostSectionHeader
import io.learnet.app.ui.utils.BaseViewHolder

/**
 * @author Bizuwork Melesse
 * created on 9/26/21
 */
class PostDetailAdapter(private val viewItems: List<*>) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        private const val TYPE_POST_DETAIL_HEADER = 0
        private const val TYPE_POST_BODY = 1
        private const val TYPE_REPLIES = 2
    }

    inner class PostDetailItemViewHolder(itemView: View) : BaseViewHolder<PostDetailItem>(itemView) {
        override fun bind(item: PostDetailItem) {
            val avatarView = itemView.findViewById<ImageView>(R.id.ivDetailPosterAvatar)
            val authorView = itemView.findViewById<TextView>(R.id.tvPostDetailAuthor)
            val postBookmarkView = itemView.findViewById<TextView>(R.id.tvPostDetailBookmark)
            val timestampView = itemView.findViewById<TextView>(R.id.tvPostDetailTimestamp)
            val postTitleView = itemView.findViewById<TextView>(R.id.tvPostDetailTitle)
            val bodyView = itemView.findViewById<TextView>(R.id.tvPostDetailBody)
            Picasso.get().load(item.avatarUrl).into(avatarView)
            postTitleView.text = item.title
            authorView.text = "${item.authorFirstName} ${item.authorLastName}"
            timestampView.text = item.timestamp
            bodyView.text = item.body
        }
    }

    inner class PostReplyItemViewHolder(itemView: View) : BaseViewHolder<PostReplyItem>(itemView) {
        override fun bind(item: PostReplyItem) {
            val avatarView = itemView.findViewById<ImageView>(R.id.ivReplyPosterAvatar)
            val authorView = itemView.findViewById<TextView>(R.id.tvPostReplyAuthor)
            val timestampView = itemView.findViewById<TextView>(R.id.tvPostReplyTimestamp)
            val bodyView = itemView.findViewById<TextView>(R.id.tvPostReplyBody)
            val voteCountView = itemView.findViewById<TextView>(R.id.tvPostReplyVoteCount)
            Picasso.get().load(item.avatarUrl).into(avatarView)
            authorView.text = "${item.authorFirstName} ${item.authorLastName}"
            timestampView.text = item.timestamp
            bodyView.text = item.body
            voteCountView.text = "${item.voteCount} votes"
        }
    }

    inner class PostDetailHeaderViewHolder(itemView: View) : BaseViewHolder<PostSectionHeader>(itemView) {
        override fun bind(item: PostSectionHeader) {
            val headerView = itemView.findViewById<TextView>(R.id.tvPostSectionHeader)
            headerView.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_POST_BODY -> {
                val postItemView = inflater.inflate(R.layout.post_detail, parent, false)
                PostDetailItemViewHolder(postItemView)
            }
            TYPE_POST_DETAIL_HEADER -> {
                val postHeaderView = inflater.inflate(R.layout.posts_section_header, parent, false)
                PostDetailHeaderViewHolder(postHeaderView)
            }
            TYPE_REPLIES -> {
                val postReplyView= inflater.inflate(R.layout.post_reply, parent, false)
                PostReplyItemViewHolder(postReplyView)
            } else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is PostDetailItemViewHolder -> holder.bind(viewItems[position] as PostDetailItem)
            is PostDetailHeaderViewHolder -> holder.bind(viewItems[position] as PostSectionHeader)
            is PostReplyItemViewHolder -> holder.bind(viewItems[position] as PostReplyItem)
        }
    }

    override fun getItemCount(): Int {
        return viewItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (viewItems[position]) {
            is PostSectionHeader -> TYPE_POST_DETAIL_HEADER
            is PostDetailItem -> TYPE_POST_BODY
            is PostReplyItem -> TYPE_REPLIES
            else -> throw IllegalArgumentException("Invalid type of data " + position)
        }
    }
}