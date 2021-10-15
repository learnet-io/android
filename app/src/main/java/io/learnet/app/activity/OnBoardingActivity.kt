package io.learnet.app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.learnet.app.R
import io.learnet.app.databinding.ActivityOnBoardingBinding
import io.learnet.app.ui.match.IntroGoalsFragment
import io.learnet.app.ui.match.MatchIntroFragment

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

//    TODO: after on-boarding is done, get a copy of a the current user from the
//     view model and and create a new and set onBoarded = true. Then set the view model with the
//     new user. MainActivity should now go through onboarding once per login session. Later, the
//     onBoarded flag should be set on the server
}