package io.learnet.app.data.dto

import com.google.firebase.Timestamp
import java.io.Serializable

/**
 * @author Bizuwork Melesse
 * created on 10/10/21
 */
data class User(
    var uid: String = "",
    var name: String = "",
    var email: String = "",
    var onBoarded: Boolean = false,
    var isNewUser: Boolean = false,
    var isCreated: Boolean = false,
    var isAuthenticated: Boolean = false,
    var createdDt: Timestamp? = null
): Serializable