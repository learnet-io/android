package io.learnet.app.data.repo

import androidx.lifecycle.MutableLiveData
import com.google.firebase.Timestamp
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import io.learnet.app.data.dto.User


/**
 * @author Bizuwork Melesse
 * created on 10/10/21
 */
class AuthRepo {
    companion object {
        const val USER = "user"
    }
    private val mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val rootRef: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val usersRef: CollectionReference = rootRef.collection(USER)

    fun firebaseSignInWithGoogle(googleAuthCredential: AuthCredential, errorCallback: () -> Unit):
            MutableLiveData<User>? {
        errorCallback()
        val userLiveData = MutableLiveData<User>()
        mFirebaseAuth.signInWithCredential(googleAuthCredential).addOnCompleteListener { authTask ->
            if (authTask.isSuccessful) {
                val isNewUser: Boolean = authTask.result.additionalUserInfo?.isNewUser == true
                val firebaseUser: FirebaseUser? = mFirebaseAuth.currentUser
                if (firebaseUser != null) {
                    val uid = firebaseUser.uid
                    val name = firebaseUser.displayName
                    val email = firebaseUser.email
                    val user = User(uid, name!!, email!!, isNewUser, !isNewUser, true,
                    null)
                    userLiveData.value = user
                }
            } else {
                errorCallback()
            }
        }
        return userLiveData
    }

    fun createUserInFirestoreIfNotExists(authenticatedUser: User, errorCallback: () -> Unit): MutableLiveData<User>? {
        val newUserMutableLiveData = MutableLiveData<User>()
        val uidRef: DocumentReference = usersRef.document(authenticatedUser.uid)
        uidRef.get().addOnCompleteListener { uidTask ->
            if (uidTask.isSuccessful) {
                val document: DocumentSnapshot = uidTask.result
                if (!document.exists()) {
                    uidRef.set(authenticatedUser).addOnCompleteListener { userCreationTask ->
                        if (userCreationTask.isSuccessful) {
                            authenticatedUser.isCreated = true
                            authenticatedUser.createdDt = Timestamp.now()
                            newUserMutableLiveData.setValue(authenticatedUser)
                        } else {
                            errorCallback()
                        }
                    }
                } else {
                    newUserMutableLiveData.value = authenticatedUser
                }
            } else {
                errorCallback()
            }
        }
        return newUserMutableLiveData
    }
}