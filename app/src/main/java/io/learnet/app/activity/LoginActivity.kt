package io.learnet.app.activity

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.shobhitpuri.custombuttons.GoogleSignInButton
import io.learnet.app.R
import io.learnet.app.databinding.ActivityLoginBinding


/**
 * @author Bizuwork Melesse
 * created on 10/10/21
 */
class LoginActivity: AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mFirebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Google Sign In options
        val gso= GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .requestProfile()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        mFirebaseAuth = FirebaseAuth.getInstance()

        val signInBtn = findViewById<GoogleSignInButton>(R.id.btn_google_sign_in)
        signInBtn.setOnClickListener(this)

        // Initialize progress bar
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait");
        progressDialog.setCancelable(false);
    }


    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_google_sign_in -> signIn()
        }
    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            progressDialog.show()
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account)
            } catch (e: ApiException) {
                e.printStackTrace()
                authFailure()
            }
        }
    }

    private fun signIn() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startForResult.launch(signInIntent)
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        mFirebaseAuth.signInWithCredential(credential)
            .addOnSuccessListener(this) {
                progressDialog.dismiss()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener(this) { e ->
                    e.printStackTrace()
                    authFailure()
            }
    }

    private fun authFailure() {
        Toast.makeText(this, getString(R.string.login_unknown_failure), Toast.LENGTH_LONG).show()
    }

}