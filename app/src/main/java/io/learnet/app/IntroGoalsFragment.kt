package io.learnet.app

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.marginBottom
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [IntroGoalsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IntroGoalsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

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
    }

    private fun initializeButtons() {
        val confident = view?.findViewById<TextView>(R.id.btn_become_confident)
        val thinking = view?.findViewById<TextView>(R.id.btn_improve_thinking)
        val people = view?.findViewById<TextView>(R.id.btn_meet_people)
        val stress = view?.findViewById<TextView>(R.id.btn_reduce_stress)
        val emotions = view?.findViewById<TextView>(R.id.btn_manage_emotions)
        val understand = view?.findViewById<TextView>(R.id.btn_understand_myself)
        val express = view?.findViewById<TextView>(R.id.btn_express_myself)
        val inspire = view?.findViewById<TextView>(R.id.btn_inspire)
        confident?.text = getString(R.string.btn_become_confident)
        thinking?.text = getString(R.string.btn_improve_thinking)
        people?.text = getString(R.string.btn_meet_people)
        stress?.text = getString(R.string.btn_reduce_stress)
        emotions?.text = getString(R.string.btn_manage_emotions)
        understand?.text = getString(R.string.btn_understand_myself)
        express?.text = getString(R.string.btn_express_myself)
        inspire?.text = getString(R.string.btn_inspire)
        val buttons = arrayListOf(
            confident,
            thinking,
            people,
            stress,
            emotions,
            understand,
            express,
            inspire
        )
        buttons.forEach {
            it?.setBackgroundResource(R.drawable.text_view_border)
            it?.textSize = 12f
            it?.setPadding(10, 4, 10 ,4)
        }
//        val fab = view?.findViewById<FloatingActionButton>(R.id.goal_submit)
//        fab?.setOnClickListener()
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

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            IntroGoalsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}