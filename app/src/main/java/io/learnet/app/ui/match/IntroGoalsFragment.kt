package io.learnet.app.ui.match

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.learnet.app.R

class IntroGoalsFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_intro_goals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeButtons()
        initializeText()
        initFabListener()
    }

    private fun initFabListener() {
        val fab = view?.findViewById<FloatingActionButton>(R.id.i_fab_intro_goals)
        fab?.setOnClickListener(this)
    }

    private fun initializeButtons() {
        val confident = view?.findViewById<TextView>(R.id.btn_become_confident)
        val thinking = view?.findViewById<TextView>(R.id.btn_improve_thinking)
        val people = view?.findViewById<TextView>(R.id.btn_meet_people)
        val stress = view?.findViewById<TextView>(R.id.btn_reduce_stress)
        val emotions = view?.findViewById<TextView>(R.id.btn_manage_emotions)
        val communication = view?.findViewById<TextView>(R.id.btn_communication)
        val express = view?.findViewById<TextView>(R.id.btn_express_myself)
        val inspire = view?.findViewById<TextView>(R.id.btn_inspire)
        confident?.text = getString(R.string.btn_become_confident)
        thinking?.text = getString(R.string.btn_improve_thinking)
        people?.text = getString(R.string.btn_meet_people)
        stress?.text = getString(R.string.btn_reduce_stress)
        emotions?.text = getString(R.string.btn_manage_emotions)
        communication?.text = getString(R.string.btn_communication)
        express?.text = getString(R.string.btn_express_myself)
        inspire?.text = getString(R.string.btn_inspire)
        val buttons = arrayListOf(
            confident,
            thinking,
            people,
            stress,
            emotions,
            communication,
            express,
            inspire
        )
        buttons.forEach {
            it?.setBackgroundResource(R.drawable.text_view_border)
            it?.textSize = 12f
            it?.setPadding(30, 20, 30 ,20)
        }
    }

    private fun initializeText() {
        val heading = view?.findViewById<TextView>(R.id.tvIntroTextHeadingFirstLine)
        val subHeading = view?.findViewById<TextView>(R.id.tvIntroTextHeadingSecondLine)
        val subSubHeading = view?.findViewById<TextView>(R.id.tvIntroTextSubheading)
        heading?.text = getString(R.string.intro_goal_heading)
        subHeading?.text = getString(R.string.intro_goal_subheading)
        subSubHeading?.text = getString(R.string.intro_goal_what_are_your_goals)
        subSubHeading?.setTextColor(Color.BLACK)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.i_fab_intro_goals -> findNavController().navigate(IntroGoalsFragmentDirections.actionIntroGoalsFragmentToMatchIntroFragment())
        }
    }
}