package io.learnet.app.data.dto

/**
 * @author Bizuwork Melesse
 * created on 10/10/21
 */
data class User(
    var uid: String,
    var name: String,
    var email: String,
    var isNewUser: Boolean,
    var isCreated: Boolean,
    var isAuthenticated: Boolean,
)