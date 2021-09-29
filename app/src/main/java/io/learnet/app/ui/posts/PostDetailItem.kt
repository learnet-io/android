package io.learnet.app.ui.posts


/**
 * @author Bizuwork Melesse
 * created on 9/26/21
 */
data class PostDetailItem(
    open val authorFirstName: String,
    val authorLastName: String,
    val avatarUrl: String,
    val title: String,
    val timestamp: String,
    val body: String,
    val voteCount: Long,
    val replyCount: Long,
    val viewCount: Long
)