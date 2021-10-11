package io.learnet.app.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.AuthCredential
import io.learnet.app.data.dto.User
import io.learnet.app.data.repo.AuthRepo


/**
 * @author Bizuwork Melesse
 * created on 10/10/21
 */
class UserAuthViewModel : ViewModel() {
    private val authRepo = AuthRepo()
    lateinit var authenticatedUserLiveData: LiveData<User>
    lateinit var createdUserLiveData: LiveData<User>

    fun createUser(authenticatedUser: User, errorCallback: () -> Unit) {
        createdUserLiveData = authRepo.createUserInFirestoreIfNotExists(authenticatedUser, errorCallback)!!
    }

    fun signInWithGoogle(googleAuthCredential: AuthCredential, errorCallback: () -> Unit) {
        authenticatedUserLiveData = authRepo.firebaseSignInWithGoogle(googleAuthCredential, errorCallback)!!
    }

}