package io.learnet.app.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.learnet.app.data.dto.User
import io.learnet.app.data.repo.SplashRepo


/**
 * @author Bizuwork Melesse
 * created on 10/10/21
 */
class SplashViewModel : ViewModel() {

    private val splashRepo = SplashRepo()
    lateinit var isUserAuthenticatedLiveData: LiveData<User>
    lateinit var userLiveData: LiveData<User>


    fun checkIfUserIsAuthenticated() {
        isUserAuthenticatedLiveData = splashRepo.checkIfUserIsAuthenticatedInFirebase()
    }

    fun setUid(uid: String) {
        userLiveData = splashRepo.addUserToLiveData(uid)
    }

}