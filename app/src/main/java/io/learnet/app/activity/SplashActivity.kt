package io.learnet.app.activity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.learnet.app.data.dto.User
import io.learnet.app.data.repo.AuthRepo
import io.learnet.app.databinding.ActivitySplashBinding
import io.learnet.app.model.SplashViewModel


class SplashActivity : AppCompatActivity() {
    private lateinit var splashViewModel: SplashViewModel
    private lateinit var binding: ActivitySplashBinding
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSplashViewModel();
        checkIfUserIsAuthenticated()
        initProgressDialog()
    }

    private fun checkIfUserIsAuthenticated() {
        splashViewModel.checkIfUserIsAuthenticated()
        splashViewModel.isUserAuthenticatedLiveData.observe(this) { user ->
            if (!user.isAuthenticated) {
                goToLoginActivity()
                finish()
            } else {
                progressDialog.show()
                getUserFromDatabase(user)
            }
        }
    }

    private fun getUserFromDatabase(user: User) {
        splashViewModel.setUid(user.uid)
        // TODO: get user profile, settings, and other details from the server

        // Get user from firestore
        splashViewModel.userLiveData.observe(this) { user ->
            progressDialog.dismiss()
            goToMainActivity(user)
            finish()
        }
    }

    private fun goToMainActivity(user: User) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(AuthRepo.USER, user)
        startActivity(intent)
        finish()
    }

    private fun goToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initSplashViewModel() {
        splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
    }

    private fun initProgressDialog() {
        // Initialize progress bar
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait")
        progressDialog.setCancelable(false)
    }
}