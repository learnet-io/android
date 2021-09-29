package io.learnet.app.ui.posts


/**
 * @author Bizuwork Melesse
 * created on 9/26/21
 */
data class PostReplyItem(
    val authorFirstName: String,
    val authorLastName: String,
    val avatarUrl: String,
    val timestamp: String,
    val body: String,
    val voteCount: Long,
)