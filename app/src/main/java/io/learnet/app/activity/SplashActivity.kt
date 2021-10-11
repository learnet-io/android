package io.learnet.app.activity

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSplashViewModel();
        checkIfUserIsAuthenticated();
    }

    private fun checkIfUserIsAuthenticated() {
        splashViewModel.checkIfUserIsAuthenticated()
        splashViewModel.isUserAuthenticatedLiveData.observe(this) { user ->
            if (!user.isAuthenticated) {
                goToLoginActivity()
                finish()
            } else {
                getUserFromDatabase(user.uid)
            }
        }
    }

    private fun getUserFromDatabase(uid: String) {
        splashViewModel.setUid(uid)
        splashViewModel.userLiveData.observe(this) { user ->
            goToMainActivity(user)
            finish()
        }
    }

    private fun goToMainActivity(user: User) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(AuthRepo.USER, user as Bundle)
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
}