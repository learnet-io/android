package io.learnet.app.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import io.learnet.app.data.dto.User


/**
 * @author Bizuwork Melesse
 * created on 10/10/21
 */
class SplashRepo {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val user: User = User("", "", "",
        isNewUser = false,
        isCreated = false,
        isAuthenticated = false
    )
    private val rootRef = FirebaseFirestore.getInstance()
    private val usersRef = rootRef.collection(AuthRepo.USER)

    fun checkIfUserIsAuthenticatedInFirebase(): MutableLiveData<User> {
        val isUserAuthenticateInFirebaseMutableLiveData: MutableLiveData<User> =
            MutableLiveData<User>()
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            user.isAuthenticated = false
            isUserAuthenticateInFirebaseMutableLiveData.setValue(user)
        } else {
            user.uid = firebaseUser.uid
            user.isAuthenticated = true
            isUserAuthenticateInFirebaseMutableLiveData.setValue(user)
        }
        return isUserAuthenticateInFirebaseMutableLiveData
    }

    fun addUserToLiveData(uid: String): MutableLiveData<User> {
        val userMutableLiveData: MutableLiveData<User> = MutableLiveData<User>()
        usersRef.document(uid!!).get().addOnCompleteListener { userTask: Task<DocumentSnapshot> ->
            if (userTask.isSuccessful) {
                val document = userTask.result
                if (document.exists()) {
                    val user: User? = document.toObject(User::class.java)
                    userMutableLiveData.value = user!!
                }
            } else {
                userTask.exception!!.message?.let { Log.e("SplashRepo", it) }
            }
        }
        return userMutableLiveData
    }
}