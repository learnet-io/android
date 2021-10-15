package io.learnet.app.ui.match

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.learnet.app.R
import io.learnet.app.activity.MainActivity
import io.learnet.app.data.dto.User
import io.learnet.app.data.repo.AuthRepo
import io.learnet.app.model.SplashViewModel

class MatchDetailFragment : Fragment(), View.OnClickListener {
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFabListener()
        initSplashViewModel()
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.i_fab_match_intro -> getUserFromDatabase()
        }
    }

    private fun initFabListener() {
        val fab = view?.findViewById<FloatingActionButton>(R.id.i_fab_match_details)
        fab?.setOnClickListener(this)
    }

    private fun initSplashViewModel() {
        splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
    }

    private fun getUserFromDatabase() {
        splashViewModel.userLiveData.observe(this) { user ->
            goToMainActivity(user)
        }
        goToMainActivity(null)
    }

    private fun goToMainActivity(user: User?) {

        val intent = Intent(activity, MainActivity::class.java)
//        intent.putExtra(AuthRepo.USER, user)
        startActivity(intent)
    }
}